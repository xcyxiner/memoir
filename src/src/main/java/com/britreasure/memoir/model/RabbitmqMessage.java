package com.britreasure.memoir.model;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午4:40
 */
public class RabbitmqMessage {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public RabbitmqMessage() {

    }

    public RabbitmqMessage(String content) {
        this.content = content;
    }
}
