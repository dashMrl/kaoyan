package top.letsgoduet.kaoyan.model;

import javax.persistence.*;

@Entity
@Table(name = "comm")
public class Communication {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long id;
    @Column(name = "title")
    public String title;
    @Column(name = "content",columnDefinition = "text not null", nullable = false)
    public String content;
    @Column(name = "u_id")
    public Long uId;
    @Column(name = "create_time")
    public long createTime;
    @Column(name = "update_time")
    public long updateTime;
    @Column(name = "level")
    public int level;
    @Column(name = "pv")
    public Long pv = 0L;

    public void setId(Long id) {
        this.id = id;
    }

    public void setuId(Long uId) {
        this.uId = uId;
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

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
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

    public Long getPv() {
        return pv;
    }

    public void setPv(Long pv) {
        this.pv = pv;
    }

    public static final int LEVEL_LOW = 2;
    public static final int LEVEL_MID = 1;
    public static final int LEVEL_HIGH = 0;
}
