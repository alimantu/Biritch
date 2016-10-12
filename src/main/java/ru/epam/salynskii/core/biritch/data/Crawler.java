package ru.epam.salynskii.core.biritch.data;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Alimantu on 08/09/16.
 */
public class Crawler {
    private final String path;

    public Crawler(String path) {
        this.path = path;
    }

    public List<NewsOld> getNewsList() {
        Gson gson = new Gson();
        ClassLoader classLoader = getClass().getClassLoader();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(classLoader.getResource(path).getFile()))) {
            JSONObject jsonObject = (JSONObject) (new JSONParser()).parse(reader);
            String name = (String) jsonObject.get("Name");
            System.out.println(name);
            JSONArray aggSites = (JSONArray) jsonObject.get("Aggregated sites");
            for (Object tmp : aggSites) {
                JSONObject intJsonObj = (JSONObject) tmp;
//                System.out.println(intJsonObj.toString());
                SinglePageCrawler spc = gson.fromJson(intJsonObj.toString(), SinglePageCrawler.class);
                System.out.println(spc.getTitle());
                List<NewsOld> nList = spc.getNews();
                System.out.println("++++++++++++++++++++++++++++++++++++");
                for (NewsOld nm : nList) {
                    System.out.println("--------------------------------");
                    System.out.println(nm.getTitle());
                    System.out.println(nm.getUrl());
//                    StringBuilder sb = new StringBuilder();
//                    nm.getBody().forEach(sb::append);
                    System.out.println(nm.getBody());
                    System.out.println("--------------------------------");
                }
                System.out.println("++++++++++++++++++++++++++++++++++++");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
