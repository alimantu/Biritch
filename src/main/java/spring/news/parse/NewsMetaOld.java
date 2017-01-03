package spring.news.parse;

public class NewsMetaOld {

    private final String title;
    private final String url;

    public NewsMetaOld(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
