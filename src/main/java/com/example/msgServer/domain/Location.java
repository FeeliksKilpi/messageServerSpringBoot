package com.example.msgServer.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long locationId;
    @Column
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageLocation")
    @JsonBackReference
    private List<Message> messages;

    public Location() {

    }
    public Location(String location) {
        super();
        this.setLocation(location);
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
