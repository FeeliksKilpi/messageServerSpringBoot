package com.example.msgServer.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChannelRepository extends CrudRepository<Channel, Long>{
    List<Channel> findByChannelName(String channelName);
}
