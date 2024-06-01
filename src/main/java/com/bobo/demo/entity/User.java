package com.bobo.demo.entity;

public class User {
    private Integer userid;
    private String username;

    private String userph;

    public String getUserph() {
        return userph;
    }

    public void setUserph(String userph) {
        this.userph = userph;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    private String userpwd;
}
