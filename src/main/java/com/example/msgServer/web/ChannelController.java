package com.example.msgServer.web;

import java.util.List;

import com.example.msgServer.ChannelService;
import com.example.msgServer.domain.Channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ChannelController {
    @Autowired
    ChannelService channelService;

    // Get mapping to list all messages
@CrossOrigin
@GetMapping("/channels")
private List<Channel> getAllChannels() {
  return channelService.getAllChannels();
}

// Get mapping to output spesific message
@CrossOrigin
@GetMapping("/channel/{channelId}")
private Channel getChannel(@PathVariable("channelId") long channelId) {
  return channelService.getChannelById(channelId);
}

// Delete mapping
@CrossOrigin
@DeleteMapping("/channel/delete/{channelId}")
private void deleteChannel(@PathVariable("channelId") long channelId) {
  channelService.delete(channelId);
}

// Post mapping that post message
@CrossOrigin
@PostMapping("/create")
private long saveChannel(@RequestBody Channel channel) {
  channelService.saveOrUpdate(channel);
  return channel.getChannelId();
}

// Put mapping that updates message detail
@CrossOrigin
@PutMapping("/channel")
private Channel update(@RequestBody Channel channel) {
  channelService.saveOrUpdate(channel);
  return channel;
}
    
}
