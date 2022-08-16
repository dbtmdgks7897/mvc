package com.google.mvc.dto;

public class TbSearchDto {
    private String title;
    private String link;
    private String des;
    private String pubDate;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }


    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }


    public String getPubDate() {
        return pubDate;
    }
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
