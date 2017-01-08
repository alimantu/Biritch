package spring.database.model;

import javax.persistence.*;

@Entity
@Table(name = "user_tags")
public class UserTags {

    @EmbeddedId
    private UserTagsPK userTagsPK;

    @MapsId("uid")
    @JoinColumn(name="uid", referencedColumnName="uid")
    @OneToOne
    private User user;

    @MapsId("tid")
    @JoinColumn(name="tid", referencedColumnName="tid")
    @OneToOne
    private Tags tags;
    private Float likes;

    public UserTagsPK getUserTagsPK() { return userTagsPK; }

    public void setUserTagsPK(UserTagsPK userTagsPK) {
        this.userTagsPK = userTagsPK;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) { this.tags = tags; }

    @Column(name = "likes")
    public Float getLikes() {
        return likes;
    }

    public void setLikes(Float likes) {
        this.likes = likes;
    }
}
