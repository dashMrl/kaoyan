package top.letsgoduet.kaoyan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comm")
public class Communication {
    @Id
    @GeneratedValue()
    public int id;
    public String title;
    public String content;
    public int uId;
    public long createTime;
    public long updateTime;
    public int level;

    public Communication(int id, String title, String content, int uId, long createTime, long updateTime, int level) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.uId = uId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.level = level;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getU_id() {
        return uId;
    }

    public void setU_id(int u_id) {
        this.uId = u_id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
