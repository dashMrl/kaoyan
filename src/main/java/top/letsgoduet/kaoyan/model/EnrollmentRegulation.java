package top.letsgoduet.kaoyan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enroll_regu")
public class EnrollmentRegulation {
    @Id
    @GeneratedValue()
    public long id;
    public String title;
    public String contnent;
    public long sId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContnent() {
        return contnent;
    }

    public void setContnent(String contnent) {
        this.contnent = contnent;
    }

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }
}
