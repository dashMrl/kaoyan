package top.letsgoduet.kaoyan.model;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long id;
    @Column(name = "uanme", nullable = false)
    public String uname;
    @Column(name = "pwd", nullable = false)
    public String pwd;
    @Column(name = "phone")
    public String phone;
    @Column(name = "role",nullable = false)
    public int role = ROLE_USER;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public static final int ROLE_MANAGER = 0;
    public static final int ROLE_USER = 1;
}
