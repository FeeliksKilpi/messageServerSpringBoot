package com.example.msgServer;

import com.example.msgServer.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsgServerApplication {
	private static final Logger log = LoggerFactory.getLogger(MsgServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MsgServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner messages(MessageRepository mrepository, ChannelRepository chrepository, LocationRepository lrepo) {
		return (args) -> {

			lrepo.save(new Location("Finland"));
			lrepo.save(new Location("Sweden"));
			lrepo.save(new Location("UK"));
			lrepo.save(new Location("Spain"));
			lrepo.save(new Location("Denmark"));

			chrepository.save(new Channel("@Main", "Pääkanava..."));
			chrepository.save(new Channel("@Opiskelu", "Kaikkea opiskeluun liittyvää"));
			chrepository.save(new Channel("@Español", "Todas las cosas para tu que estudies el idioma"));

			mrepository.save(new Message("This is a representation how this messaging client UI looks on this React App.", "blue", chrepository.findByChannelName("@Main").get(0), "#developement", lrepo.findByLocation("Finland").get(0), 3));
			mrepository.save(new Message("Mitä tehdä Porissa perjantai iltana?", "#a7ecf2", chrepository.findByChannelName("@Español").get(0), "#tervehdys", lrepo.findByLocation("Spain").get(0), 3));
			mrepository.save(new Message("Message has: Channel, location, hashtag, likes, color...", "#3e9cbf", chrepository.findByChannelName("@Main").get(0), "#socialmedia", lrepo.findByLocation("Finland").get(0), 3));
			mrepository.save(new Message("Upvoting or downvoting works by clicking the arrows. Also, a message can be deleted from the three dots option panel.", "#a7ecf2", chrepository.findByChannelName("@Main").get(0), "#help", lrepo.findByLocation("Sweden").get(0), 8));
			mrepository.save(new Message("Kuinka jaksatte opiskella kursseja jotka ei kiinnosta? Jeesiä kaivataan...", "#f26d50", chrepository.findByChannelName("@Opiskelu").get(0), "#huuhaa", lrepo.findByLocation("Finland").get(0), 1));

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
