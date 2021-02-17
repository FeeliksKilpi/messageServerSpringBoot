package com.example.msgServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.msgServer.domain.Channel;
import com.example.msgServer.domain.ChannelRepository;
import com.example.msgServer.domain.Message;
import com.example.msgServer.domain.MessageRepository;

@SpringBootApplication
public class MsgServerApplication {
	private static final Logger log = LoggerFactory.getLogger(MsgServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MsgServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner messages(MessageRepository mrepository, ChannelRepository chrepository) {
		return (args) -> {
			
			chrepository.save(new Channel("@Main", "Pääkanava..."));
			chrepository.save(new Channel("@Opiskelu", "Kaikkea opiskeluun liittyvää"));
			chrepository.save(new Channel("@Español", "Todas las cosas para tu que estudies el idioma"));

			mrepository.save(new Message("Testiviesti", "blue", chrepository.findByChannelName("@Main").get(0), "#testi", "Helsinki", 3));
			mrepository.save(new Message("Mitä tehdä Porissa perjantai iltana?", "#a7ecf2", chrepository.findByChannelName("@Español").get(0), "#tervehdys", "Pori", 3));
			mrepository.save(new Message("This fake Jodel sucks! What is this bullshit!?", "#3e9cbf", chrepository.findByChannelName("@Main").get(0), "#COPYCAT", "Pori", 3));
			mrepository.save(new Message("Whaddaya want kiddo", "#3e9cbf", chrepository.findByChannelName("@Main").get(0), "#weirdo", "Korso", 8));
			mrepository.save(new Message("Kuinka jaksatte opiskella kursseja jotka ei kiinnosta? Jeesiä kaivataan...", "#f26d50", chrepository.findByChannelName("@Opiskelu").get(0), "#huuhaa", "Helsinki", 1));

			System.out.println(mrepository.findAll());
			System.out.println(chrepository.findAll());

			log.info("Saved a couple of Messages and Channels...");

			log.info("Fetched all messages");
			for (Message message : mrepository.findAll()) {
				log.info(message.toString());
			}
		};

	} 

}
