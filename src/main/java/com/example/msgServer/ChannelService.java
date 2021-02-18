package com.example.msgServer;

import java.util.ArrayList;
import java.util.List;

import com.example.msgServer.domain.ChannelRepository;
import com.example.msgServer.domain.Channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {
@Autowired
ChannelRepository chrepo;

// Get all with findAll() or CRUD repo
public List<Channel> getAllChannels() {
    List<Channel> channels = new ArrayList<Channel>();
    chrepo.findAll().forEach(channel1 -> channels.add(channel1));
    return channels;
}

// Get channel by ID
public Channel getChannelById(long id) {
    return chrepo.findById(id).get();
}
// Get channel by ID
public Channel getChannelByName(String name) {
    return chrepo.findByChannelName(name).get(0);
}

// Save or update a channels attributes
public void saveOrUpdate(Channel channel) {
    chrepo.save(channel);
}

// Delete a spesific channel
public void delete(long id) {
    chrepo.deleteById(id);
}

// Update
public void update(Channel channel, long channelId) {
    chrepo.save(channel);
}

}
