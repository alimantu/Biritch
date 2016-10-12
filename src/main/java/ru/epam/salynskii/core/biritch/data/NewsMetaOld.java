package ru.epam.salynskii.core.biritch.data;

/**
 * Created by Alimantu on 08/09/16.
 */
public class NewsMetaOld {

    protected final String title;
    protected final String url;

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
