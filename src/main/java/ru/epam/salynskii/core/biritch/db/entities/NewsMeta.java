package ru.epam.salynskii.core.biritch.db.entities;

import javax.persistence.*;

/**
 * Created by Alimantu on 18/09/16.
 */
@Entity
//@Table(name = "newsMeta")
public class NewsMeta {
    @Id
    @Column(name = "id")
//    @TableGenerator(name="TABLE_GEN",table="T_GENERATOR",pkColumnName="GEN_KEY",pkColumnValue="TEST",valueColumnName="GEN_VALUE",initialValue=1,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")//TABLE, generator="TABLE_GEN")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @Column(name = "tag")
    private String tag;

    public NewsMeta() {}

    public NewsMeta(String title, String url, String tag) {
        this.title = title;
        this.url = url;
        this.tag = tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
