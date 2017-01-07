package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "news_metadata_tags")
public class NewsMetadataTags {

    private Integer nmtid;
    private NewsMetadata newsMetadata;
    private Tags tags;
    private Float percentage;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NMTID", unique = true, nullable = false)
    public Integer getId() {
        return this.nmtid;
    }

    public void setId(Integer nmtid) {
        this.nmtid = nmtid;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NMID")
    public NewsMetadata getNewsMetadata() {
        return newsMetadata;
    }

    public void setNewsMetadata(NewsMetadata newsMetadata) { this.newsMetadata = newsMetadata; }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TID")
    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) { this.tags = tags; }

    @Column(name = "PERCENTAGE")
    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
