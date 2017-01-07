package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "news_text")
public class NewsText {

    private Integer ntid;
    private String text;
    private Integer serialNumber;
    private NewsMetadata newsMetadata;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NTID", unique = true, nullable = false)
    public Integer getId() {
        return this.ntid;
    }

    public void setId(Integer ntid) {
        this.ntid = ntid;
    }

    @Column(name = "TEXT", nullable = false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
