package ru.epam.salynskii.core.biritch.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alimantu on 03/09/16.
 */
public class SinglePageCrawler {
//    private Document document;
    private String name;
    private String url;
    private String divClass;
    private ArrayList<String> bodyTags;
    private ArrayList<String> removeText;
//    private boolean shortLinks;
//    private String textTagname1;
//    private String textTagname2;

    public SinglePageCrawler(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getTitle() throws IOException {
        return Jsoup.connect(url).get().title();
    }

    public List<NewsMetaOld> getNewsMeta() throws IOException {
//        Element tmp = document.select("div.an").first();
//        Element tmp = document.select("div.Page.Page--asSections").first();
//        System.out.println(document.outerHtml());
//        tmp.select()
//        Elements links = tmp.select("a[href]");
        Document document = Jsoup.connect(url).get();
        Elements links = document.select(divClass);
        links = links.select("a[href]");
        return links.stream()
                .map(link -> new NewsMetaOld(link.text(), /*(shortLinks ? url : "") +*/ link.absUrl("href")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<NewsOld> getNews() throws IOException {
        List<NewsMetaOld> tmp = getNewsMeta();
        ArrayList<NewsOld> result = new ArrayList<>();
        for (NewsMetaOld nm : tmp) {
//            System.out.println(nm.getUrl());
//            System.out.println(nm.getTitle());
//            System.out.println(nm.getUrl());
            Document document = Jsoup.connect(nm.getUrl()).get();
//            System.out.println(document.outerHtml());
//            Whitelist whitelist = new Whitelist();
//            whitelist.addAttributes(textTagname2);
            /*String text = */
            Elements tmpElements = document.getAllElements();
//            System.out.println(tmpElements.outerHtml());
            for (String bodyTag : bodyTags) {
//                System.out.println(tmpElements.text());
                tmpElements = tmpElements.select(bodyTag);/*.removeAttr("href").text();*/
//                System.out.println(tmpElements.text());
            }
            ArrayList<String> body = new ArrayList<>();
            tmpElements.forEach(e -> {
//                System.out.println(e.text());
                if (e.hasText()) {
                    String[] tmpText = new String[1];
                    tmpText[0] = e.text();
                    removeText.forEach(pattern -> {
                        tmpText[0] = tmpText[0].replaceAll(pattern, "");
//                        System.out.println(tmpText[0]);
                    });
                    body.add(tmpText[0]);
                }
            });
//            String text = tmpElements.text();
//            String html = document.outerHtml();
//            System.out.println(html);
//            System.out.println(text);
//            ArrayList<String> text = elements.stream().map(Element::text)
//                    .collect(Collectors.toCollection(ArrayList::new));
//            for (String s : text) {
//                System.out.println(s);
//            }
            if (body.stream().map(String::length).reduce((s1, s2) -> s1 + s2).orElse(0) > 300) {
                result.add(new NewsOld(nm, body));
            }
        }
        System.out.println("Total size: " + result.size());
        return result;
    }

    @Override
    public String toString(){
        return "Name: " + name + System.lineSeparator() +
                "Url: " + url + System.lineSeparator();
    }
}
