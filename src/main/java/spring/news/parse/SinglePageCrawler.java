package spring.news.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SinglePageCrawler {

    private String name;
    private String url;
    private String divClass;
    private ArrayList<String> bodyTags;
    private String hashTags;
    private ArrayList<String> removeText;

    public String getTitle() throws IOException {
        return Jsoup.connect(url).get().title();
    }

    public List<NewsMetaOld> getNewsMeta() throws IOException {

        Document document = Jsoup.connect(url).get();
        Elements links = document.select(divClass);
        links = links.select("a[href]");
        return links.stream()
                .map(link -> new NewsMetaOld(link.text(), link.absUrl("href")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<NewsOld> getNews() throws IOException {

        List<NewsMetaOld> tmp = getNewsMeta();
        ArrayList<NewsOld> result = new ArrayList<>();
        for (NewsMetaOld nm : tmp) {
            Document document = Jsoup.connect(nm.getUrl()).get();
            Elements tmpElements = document.getAllElements();
            List<String> hashTag = parseHashtag(document);
            for (String bodyTag : bodyTags) {
                tmpElements = tmpElements.select(bodyTag);
            }
            ArrayList<String> body = new ArrayList<>();
            tmpElements.forEach(e -> {
                if (e.hasText()) {
                    String[] tmpText = new String[1];
                    tmpText[0] = e.text();
                    removeText.forEach(pattern -> {
                        tmpText[0] = tmpText[0].replaceAll(pattern, "");
                    });
                    body.add(tmpText[0]);
                }
            });
            if (body.stream().map(String::length).reduce((s1, s2) -> s1 + s2).orElse(0) > 300) {
                result.add(new NewsOld(nm, body, hashTag));
            }
        }
        System.out.println("Total size: " + result.size());
        return result;
    }

    private List<String> parseHashtag(Document document) {

        if (!hashTags.equals("")) {
            Elements links = document.select(hashTags);
            links = links.select("a[href]");
            return links.stream()
                    .map(Element::text)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public String toString(){
        return "Name: " + name + System.lineSeparator() +
                "Url: " + url + System.lineSeparator();
    }
}
