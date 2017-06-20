package com.journaldev.search.model;

import javax.persistence.*;

@Entity
@Table(name = "problem")
public class Problem {

    @Id
    @Column(name="pid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pid;
    private String content;
    /*private String title;*/

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
