package spring.database.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NewsMetadataUsersPK implements Serializable{

    protected Integer nmid;
    protected Integer uid;

    public NewsMetadataUsersPK() {}

    public NewsMetadataUsersPK(Integer nmid, Integer uid) {
        this.nmid = nmid;
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsMetadataUsersPK)) return false;
        NewsMetadataUsersPK that = (NewsMetadataUsersPK) o;
        return Objects.equals(nmid, that.nmid) &&
                Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nmid, uid);
    }
}
