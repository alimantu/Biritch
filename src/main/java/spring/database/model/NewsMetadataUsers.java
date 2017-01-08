package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "news_metadata_users")
public class NewsMetadataUsers {

    @EmbeddedId
    private NewsMetadataUsersPK newsMetadataUsersPK;

    @MapsId("uid")
    @JoinColumn(name="uid", referencedColumnName="uid")
    @OneToOne
    private User user;

    @MapsId("nmid")
    @JoinColumn(name="nmid", referencedColumnName="nmid")
    @OneToOne
    private NewsMetadata newsMetadata;
    private Integer stars;

    public NewsMetadataUsersPK getNewsMetadataUsersPK() { return newsMetadataUsersPK; }

    public void setNewsMetadataUsersPK(NewsMetadataUsersPK newsMetadataUsersPK) {
        this.newsMetadataUsersPK = newsMetadataUsersPK;
    }

    public NewsMetadata getNewsMetadata() { return newsMetadata; }

    public void setNewsMetadata(NewsMetadata newsMetadata) {
        this.newsMetadata = newsMetadata;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "stars", nullable = false)
    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

}
