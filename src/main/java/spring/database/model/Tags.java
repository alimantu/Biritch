package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tags {

    private Integer tid;
    private String tname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TID", unique = true, nullable = false)
    public Integer getId() {
        return this.tid;
    }

    public void setId(Integer tid) {
        this.tid = tid;
    }

    @Column(name = "TNAME", nullable = false)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

}
