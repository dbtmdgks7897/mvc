package com.google.mvc.dto;

public class TbUserDto {
    private int id;
    private String email;
    private String pw;
    private String name;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
