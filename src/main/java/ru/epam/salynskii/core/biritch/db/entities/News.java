package ru.epam.salynskii.core.biritch.db.entities;

import javax.persistence.*;

/**
 * Created by Alimantu on 18/09/16.
 */
@Entity
//@Table(name = "NEWS")
public class News {
    @Id
//    @Column
    private String id;

//    @ManyToOne
    @Column
    private Long news_id;

    public News() {}

    public News(String id, Long news_id){
        this.id = id;
        this.news_id = news_id;
    }

    public void setNews_id(Long news_id) {
        this.news_id = news_id;
    }

    public String getId() {

        return id;
    }

    public Long getNews_id() {
        return news_id;
    }
}
