package com.britreasure.memoir.model;

import org.springframework.data.annotation.Id;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午4:53
 */
public class RabbitmqLastMessage {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;

    /**
     * 获取队列名
     *
     * @return 队列名
     */
    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    private String queueName;

    /**
     * 获取制定队列的消息内容
     *
     * @return 消息内容
     */
    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    private String msgContent;

    public RabbitmqLastMessage(String queueName, String msgContent) {
        this.queueName = queueName;
        this.msgContent = msgContent;
    }
}
