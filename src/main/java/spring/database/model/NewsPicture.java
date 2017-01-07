package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "news_picture")
public class NewsPicture {

    private Integer npid;
    private byte[] picture;
    private Integer serialNumber;
    private NewsMetadata newsMetadata;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NPID", unique = true, nullable = false)
    public Integer getId() {
        return this.npid;
    }

    public void setId(Integer npid) {
        this.npid = npid;
    }

    @Column(name = "PICTURE", nullable = false)
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "SERIAL_NUMBER")
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NMID")
    public NewsMetadata getNewsMetadata() {
        return newsMetadata;
    }

    public void setNewsMetadata(NewsMetadata newsMetadata) { this.newsMetadata = newsMetadata; }
}
