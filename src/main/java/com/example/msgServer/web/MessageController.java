package com.example.msgServer.web;

import java.util.List;

import javax.persistence.PostUpdate;

import com.example.msgServer.MessageService;
import com.example.msgServer.domain.Message;
import com.example.msgServer.domain.MessageRepository;

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
public class MessageController {
    // Autowire Service-classs
    @Autowired
    MessageService messageService;

// Get mapping to list all messages
@CrossOrigin
@GetMapping("/messages")
private List<Message> getAllMessages() {
  return messageService.getAllMessages();
}

// Get mapping to output spesific message
@CrossOrigin
@GetMapping("/message/{messageId}")
private Message getMessage(@PathVariable("messageId") long messageId) {
  return messageService.getMessageById(messageId);
}

// Delete mapping
@CrossOrigin
@DeleteMapping("/message/delete/{messageId}")
private void deleteMessage(@PathVariable("messageId") long messageId) {
  messageService.delete(messageId);
}

// Post mapping that post message
@CrossOrigin
@PostMapping("/publish")
private long saveMessage(@RequestBody Message message) {
  messageService.saveOrUpdate(message);
  return message.getMessageId();
}

// UPVOTE
@CrossOrigin
@PostMapping("/upvote/{messageId}")
private void upvote(@RequestBody Message message, @PathVariable("messageId") long messageId) {
  messageService.upvote(message, messageId);
}

// Put mapping that updates message detail
@CrossOrigin
@PutMapping("/message")
private Message update(@RequestBody Message message) {
  messageService.saveOrUpdate(message);
  return message;
}

  /*
Try post with curl:
curl -d '{"messageText":"testi", "messageColor":"testi", "messageChannel":"@Testit", "messageHashtag":"#testi", "messageLocation":"Helsinki", "messageLikes":1}' -H "Content-Type: application/json" -X POST http://localhost:8080/publish
  */

 
}
