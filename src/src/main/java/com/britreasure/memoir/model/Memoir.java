package com.britreasure.memoir.model;

import org.springframework.data.annotation.Id;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午6:00
 */
public class Memoir {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    private String mark;
    

    public Memoir() {

    }

}
