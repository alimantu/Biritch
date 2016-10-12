package ru.epam.salynskii.core.biritch.data;

import java.util.List;

/**
 * Created by Alimantu on 08/09/16.
 */
public class NewsOld extends NewsMetaOld {
    private List<String> body;

    public NewsOld(String title, String url, List<String> body) {
        super(title, url);
        this.body = body;
    }

    public NewsOld(NewsMetaOld newsMeta, List<String> body) {
        super(newsMeta.title, newsMeta.url);
        this.body = body;
    }

    public List<String> getBody() {
        return body;
    }

    public void setBody(List<String> body) {
        this.body = body;
    }
}
