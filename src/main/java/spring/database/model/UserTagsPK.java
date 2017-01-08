package spring.database.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserTagsPK implements Serializable {

    protected Integer uid;
    protected Integer tid;

    public UserTagsPK() {}

    public UserTagsPK(Integer uid, Integer tid) {
        this.uid = uid;
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTagsPK)) return false;
        UserTagsPK that = (UserTagsPK) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, tid);
    }
}
