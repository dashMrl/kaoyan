package top.letsgoduet.kaoyan.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name = "reference_book")
public class ReferenceBook {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long id;
    @Column(name = "title")
    public String title;
    @Column(name = "content",columnDefinition = "text not null")
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
