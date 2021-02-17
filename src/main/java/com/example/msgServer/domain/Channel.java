package com.example.msgServer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;

@Entity
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "channelId")*/
@Table
public class Channel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long channelId;
    @Column
    private String channelName;
    @Column
    private String channelDesc;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageChannel")
    @JsonManagedReference
    private List<Message> messages;

public Channel() {

}
public Channel(String channelName, String channelDesc) {
    super();
    this.setChannelName(channelName);
    this.setChannelDesc(channelDesc);
}
public long getChannelId() {
    return channelId;
}
public void setChannelId(long channelId) {
    this.channelId = channelId;
}
public String getChannelName() {
    return channelName;
}
public void setChannelName(String channelName) {
    this.channelName = channelName;
}
public String getChannelDesc() {
    return channelDesc;
}
public void setChannelDesc(String channelDesc) {
    this.channelDesc = channelDesc;
}
public List<Message> getMessages() {
    return messages;
}
public void setMessages(List<Message> messages) {
    this.messages = messages;
}


}