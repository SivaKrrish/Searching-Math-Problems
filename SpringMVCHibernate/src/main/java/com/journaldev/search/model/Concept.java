package com.journaldev.search.model;

import javax.persistence.*;


@Entity
@Table(name = "concept")
public class Concept {

    @Id
    @Column(name="cid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cid;

    private String title;

    private String content;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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
}
