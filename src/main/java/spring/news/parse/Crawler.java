package spring.news.parse;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Crawler {

    private final String path;

    public Crawler(String path) {
        this.path = path;
    }

    public List<NewsOld> getNewsList() throws URISyntaxException {

        Gson gson = new Gson();
        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println(classLoader.getResource(path).toURI());
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(classLoader.getResource(path).toURI()))) {
            JSONObject jsonObject = (JSONObject) (new JSONParser()).parse(reader);
            String name = (String) jsonObject.get("Name");
            System.out.println(name);
            JSONArray aggSites = (JSONArray) jsonObject.get("Aggregated sites");

            System.out.println("write in file begin");
            try(FileWriter writer = new FileWriter("F:\\Biritch\\news.txt", false))
            {

            for (Object tmp : aggSites) {
                JSONObject intJsonObj = (JSONObject) tmp;
                SinglePageCrawler spc = gson.fromJson(intJsonObj.toString(), SinglePageCrawler.class);
                System.out.println(spc.getTitle());
                List<NewsOld> nList = spc.getNews();


                    // запись всей строки

                    for (NewsOld nm : nList) {
                        writer.write("--------------------------------");
                        writer.write("\r\n");
                        writer.write(nm.getTitle());
                        writer.write("\r\n");
                        writer.write(nm.getUrl());
                        writer.write("\r\n");
                        writer.write(String.valueOf(nm.getBody()));
                        writer.write("\r\n");
                        writer.write(String.valueOf(nm.getHashTags()));
                        writer.write("\r\n");
                        writer.write("--------------------------------");
                        writer.write("\r\n");
                        writer.write("\r\n");
                    }
                    System.out.println("other site");

                    /*String text = "Мама мыла раму, раму мыла мама";
                    writer.write(text);
                    // запись по символам
                    writer.write("\r\n");
                    writer.append('E');*/



                /*System.out.println("++++++++++++++++++++++++++++++++++++");
                for (NewsOld nm : nList) {
                    System.out.println("--------------------------------");
                    System.out.println(nm.getTitle());
                    System.out.println(nm.getUrl());
                    System.out.println(nm.getBody());
                    System.out.println("--------------------------------");
                }
                System.out.println("++++++++++++++++++++++++++++++++++++");*/
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println("end");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
