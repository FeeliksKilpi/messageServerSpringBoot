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
			mrepository.save(new Message("Testiviesti", "blue", "@Main", "#testi", "Helsinki", 3));
			mrepository.save(new Message("Mitä tehdä Porissa perjantai iltana?", "#a7ecf2", "@Main", "#tervehdys", "Pori", 3));
			mrepository.save(new Message("This fake Jodel sucks! What is this bullshit!?", "#3e9cbf", "@Main", "#COPYCAT", "Pori", 3));
			mrepository.save(new Message("Whaddaya want kiddo", "#3e9cbf", "@Main", "#weirdo", "Korso", 8));
			mrepository.save(new Message("Kuinka jaksatte opiskella kursseja jotka ei kiinnosta? Jeesiä kaivataan...", "#f26d50", "@opiskelu", "#huuhaa", "Helsinki", 1));
			System.out.println(mrepository.findAll());

			log.info("Saved a couple of messages");

			log.info("Fetched all messages");
			for (Message message : mrepository.findAll()) {
				log.info(message.toString());
			}
		};

	} 

}
