package spring.news.parse;

import java.util.List;

public class NewsOld extends NewsMetaOld {

    private List<String> body;
    private List<String> hashTags;

    public NewsOld(String title, String url, List<String> body,
                   List<String> hashTags) {
        super(title, url);
        this.body = body;
        this.hashTags = hashTags;
    }

    public NewsOld(NewsMetaOld newsMeta, List<String> body,
                   List<String> hashTags) {
        super(newsMeta.getTitle(), newsMeta.getUrl());
        this.body = body;
        this.hashTags = hashTags;
    }

    public List<String> getBody() {
        return body;
    }

    public List<String> getHashTags() { return hashTags; }

    public void setBody(List<String> body) {
        this.body = body;
    }
}
