package top.letsgoduet.kaoyan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @Column(name = "id")
    public Long id;
    @Column(name = "title")
    public String title;
    @Column(name = "content")
    public String content;
    @Column(name = "s_id")
    public Long sId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }
}
