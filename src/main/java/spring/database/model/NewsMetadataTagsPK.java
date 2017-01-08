package spring.database.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NewsMetadataTagsPK implements Serializable {

    protected Integer nmid;
    protected Integer tid;

    public NewsMetadataTagsPK() {}

    public NewsMetadataTagsPK(Integer nmid, Integer tid) {
        this.nmid = nmid;
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsMetadataTagsPK)) return false;
        NewsMetadataTagsPK that = (NewsMetadataTagsPK) o;
        return Objects.equals(nmid, that.nmid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nmid, tid);
    }
}
