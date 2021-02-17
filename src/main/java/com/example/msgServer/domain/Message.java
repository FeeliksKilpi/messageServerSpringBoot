package com.example.msgServer.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// Class is an entity
@Entity
// Class name is table name also
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "messageId")*/
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long messageId;
    @Column
    private String messageText;
    @Column
    private String messageColor;

    @ManyToOne
    @JsonBackReference
    @JoinColumn
    private Channel messageChannel;
    @Column
    private String messageHashtag;
    @Column
    private String messageLocation;
    @Column
    private int messageLikes;

    public Message() {

    }

    public Message(String messageText, String messageColor, Channel messageChannel, String messageHashtag,
            String messageLocation, int messageLikes) {
        super();
        this.setMessageText(messageText);
        this.setMessageColor(messageColor);
        this.setMessageChannel(messageChannel);
        this.setMessageHashtag(messageHashtag);
        this.setMessageLocation(messageLocation);
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
    public Channel getMessageChannel() {
        return messageChannel;
    }
    public void setMessageChannel(Channel messageChannel) {
        this.messageChannel = messageChannel;
    }
    public String getMessageColor() {
        return messageColor;
    }
    public void setMessageColor(String messageColor) {
        this.messageColor = messageColor;
    }
    public String getMessageLocation() {
        return messageLocation;
    }
    public void setMessageLocation(String messageLocation) {
        this.messageLocation = messageLocation;
    }


}
