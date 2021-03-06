package com.example.msgServer;
import java.util.ArrayList;
import java.util.List;

import com.example.msgServer.domain.Message;
import com.example.msgServer.domain.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
@Autowired
MessageRepository msgRepo;

// Get all with findAll() or CRUD repo
public List<Message> getAllMessages() {
    List<Message> messages = new ArrayList<Message>();
    msgRepo.findAll().forEach(message1 -> messages.add(message1));
    return messages;
}

// Get message by ID
public Message getMessageById(long id) {
    return msgRepo.findById(id).get();
}

// Save or update a messages attributes
public void saveOrUpdate(Message message) {
    msgRepo.save(message);
}

// Delete a spesific message
public void delete(long id) {
    msgRepo.deleteById(id);
}

// Update
public Message update(Message message) {
    msgRepo.save(message);
    return message;
}

// Upvote message
public void upvote(long messageId) {
    Message upvoteMessage = new Message();
    upvoteMessage = msgRepo.findById(messageId).get();
    upvoteMessage.setMessageLikes(upvoteMessage.getMessageLikes() + 1);
    msgRepo.save(upvoteMessage);
}

}
