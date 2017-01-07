package spring.database.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news_metadata")
public class NewsMetadata {

    private Integer nmid;
    private String nmname;
    private Date releaseDate;
    private Sources sources;
    private String sourceLink;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NMID", unique = true, nullable = false)
    public Integer getId() {
        return this.nmid;
    }

    public void setId(Integer nmid) {
        this.nmid = nmid;
    }

    @Column(name = "NMNAME", nullable = false)
    public String getNmname() {
        return nmname;
    }

    public void setNmname(String nmname) {
        this.nmname = nmname;
    }

    @Column(name = "release_date", nullable = false)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SID")
    public Sources getSources() {
        return sources;
    }

    public void setSources(Sources sources) { this.sources = sources; }

    @Column(name = "SOURCE_LINK")
    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }
}
