package com.example.msgServer.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>{
    List<Message> findByMessageText(String messageText);
}
