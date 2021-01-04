package com.example.msgServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.msgServer.domain.Message;
import com.example.msgServer.domain.MessageRepository;

@SpringBootApplication
public class MsgServerApplication {
	private static final Logger log = LoggerFactory.getLogger(MsgServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MsgServerApplication.class, args);
	}
	@Bean
	public CommandLineRunner messages(MessageRepository mrepository) {
		return (args) -> {
			mrepository.save(new Message("Testiviesti", "blue", "@Main", "#testi", 3));
			mrepository.save(new Message("Terve kaikki!", "green", "@Main", "#tervehdys", 3));
			System.out.println(mrepository.findAll());

			log.info("Saved a couple of messages");

			log.info("Fetched all messages");
			for (Message message : mrepository.findAll()) {
				log.info(message.toString());
			}
		};

	}

}
