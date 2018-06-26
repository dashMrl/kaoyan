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
    public int id;
    public String title;
    public String contnent;
    public int sId;

    public EnrollmentRegulation(int id, String title, String contnent, int sId) {
        this.id = id;
        this.title = title;
        this.contnent = contnent;
        this.sId = sId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }
}
