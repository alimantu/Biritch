package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "news_metadata_tags")
public class NewsMetadataTags {

    @EmbeddedId
    private NewsMetadataTagsPK newsMetadataTagsPK;
    @MapsId("nmid")
    @JoinColumn(name="nmid", referencedColumnName="nmid")
    @OneToOne
    private NewsMetadata newsMetadata;

    @MapsId("tid")
    @JoinColumn(name="tid", referencedColumnName="tid")
    @OneToOne
    private Tags tags;
    private Float percentage;

    public NewsMetadataTagsPK getNewsMetadataTagsPK() { return newsMetadataTagsPK; }

    public void setNewsMetadataTagsPK(NewsMetadataTagsPK newsMetadataTagsPK) {
        this.newsMetadataTagsPK = newsMetadataTagsPK;
    }

    public NewsMetadata getNewsMetadata() { return newsMetadata; }

    public void setNewsMetadata(NewsMetadata newsMetadata) {
        this.newsMetadata = newsMetadata;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) { this.tags = tags; }

    @Column(name = "percentage")
    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
