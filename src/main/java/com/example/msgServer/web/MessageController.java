package com.example.msgServer.web;

import java.util.List;

import com.example.msgServer.domain.Message;
import com.example.msgServer.domain.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
    @Autowired
    private MessageRepository mrepository;

@RequestMapping(value="/messages", method = RequestMethod.GET)
public @ResponseBody List<Message> messagesListRest() {
    return (List <Message>) mrepository.findAll();
}

@PostMapping("/publish")
  Message newMessage(@RequestBody Message newMessage) {
    return mrepository.save(newMessage);
  }

  /*
Try post with curl:
curl -d '{"messageText":"testi", "messageColor":"testi", "messageChannel":"@Testit", "messageHashtag":"#testi", "messageLikes":1}' -H "Content-Type: application/json" -X POST http://localhost:8080/publish
  */


}
