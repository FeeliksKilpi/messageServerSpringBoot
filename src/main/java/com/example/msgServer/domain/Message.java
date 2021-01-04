package com.example.msgServer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long messageId;
    private String messageText;
    private String messageColor;
    private String messageChannel;
    private String messageHashtag;
    private int messageLikes;

    public Message() {

    }

    public Message(String messageText, String messageColor, String messageChannel, String messageHashtag,
            int messageLikes) {
        super();
        this.setMessageText(messageText);
        this.setMessageColor(messageColor);
        this.setMessageChannel(messageChannel);
        this.setMessageHashtag(messageHashtag);
        this.setMessageLikes(messageLikes);
    }

    public Long getMessageId() {
        return messageId;
    }
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public int getMessageLikes() {
        return messageLikes;
    }
    public void setMessageLikes(int messageLikes) {
        this.messageLikes = messageLikes;
    }
    public String getMessageHashtag() {
        return messageHashtag;
    }
    public void setMessageHashtag(String messageHashtag) {
        this.messageHashtag = messageHashtag;
    }
    public String getMessageChannel() {
        return messageChannel;
    }
    public void setMessageChannel(String messageChannel) {
        this.messageChannel = messageChannel;
    }
    public String getMessageColor() {
        return messageColor;
    }
    public void setMessageColor(String messageColor) {
        this.messageColor = messageColor;
    }


}
