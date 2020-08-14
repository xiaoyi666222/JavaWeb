package com.spring.entity;

public class News {//自己生成GetSetToStringConstruct

    private Integer id;
    private String title;
    private String author;
    private String content;
    private String pubdate;
    private String keyword;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}


