package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "user_tags")
public class UserTags {

    private Integer utid;
    private User user;
    private Tags tags;
    private Float likes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UTID", unique = true, nullable = false)
    public Integer getId() {
        return this.utid;
    }

    public void setId(Integer utid) {
        this.utid = utid;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UID")
    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TID")
    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) { this.tags = tags; }

    @Column(name = "LIKES")
    public Float getLikes() {
        return likes;
    }

    public void setLikes(Float likes) {
        this.likes = likes;
    }
}
