package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "sources")
public class Sources {

    private Integer sid;
    private String sname;
    private String surl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SID", unique = true, nullable = false)
    public Integer getId() {
        return this.sid;
    }

    public void setId(Integer sid) {
        this.sid = sid;
    }

    @Column(name = "SNAME", nullable = false)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Column(name = "SURL", nullable = false)
    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
