package com.example.twitter_clone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.twitter_clone.repository.MessageRepository;

@SpringBootApplication
public class TwitterCloneApplication implements CommandLineRunner{
	
	@Autowired MessageRepository ob;

	public static void main(String[] args) {
		SpringApplication.run(TwitterCloneApplication.class, args);
		System.out.print("Hello World");
	}
	
	@Override
	public void run(String... args) throws Exception
    {
        // Inserting the test data in the mysql table.
//		List<Message> initialMessages = Arrays.asList(
//				new Message("Hello, this is Hamdi's first message.", 1L),
//			    new Message("Welcome to my channel!", 1L),
//
//			    new Message("Iron Man here! Ready to save the world.", 8L),
//			    new Message("Iron Man's second message.", 8L),
//
//			    new Message("Captain America reporting for duty.", 9L),
//			    new Message("Stay strong and resilient.", 9L),
//
//			    new Message("Thor, God of Thunder!", 10L),
//			    new Message("Feel the power of Mjolnir.", 10L),
//
//			    new Message("Hulk smash!", 11L),
//			    new Message("Hulk's second message.", 11L),
//
//			    new Message("Spider-Man swinging into action!", 14L),
//			    new Message("With great power comes great responsibility.", 14L),
//
//			    new Message("Black Panther is here to protect.", 15L),
//			    new Message("Wakanda forever!", 15L)
//	        );
//		
//		for (Message message : initialMessages) {
//            Optional<Message> existingMessage = ob.findByUserIdAndContent(message.getUserId(),message.getContent());
//            if (existingMessage.isPresent()) {
//            	continue;
//            } else {
//                ob.save(message);
//                System.out.println("Message " + message.getContent() + " created successfully");
//            }
//        }

    }

}
