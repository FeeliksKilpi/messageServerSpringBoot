package com.example.msgServer.web;

import java.util.List;

import com.example.msgServer.domain.Message;
import com.example.msgServer.domain.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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



}
