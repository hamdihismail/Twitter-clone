package com.example.twitter_clone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.twitter_clone.model.Subscription;
import com.example.twitter_clone.repository.SubscriptionRepository;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
	
	@Autowired 
private SubscriptionRepository subscriptionRepository;

@PostMapping(path="/add") // Map ONLY POST Requests
public @ResponseBody String addNewSubscripiton (@RequestParam Long subscriberId
 , @RequestParam Long producerId) {

Subscription n = new Subscription(subscriberId,producerId);
subscriptionRepository.save(n);
return "Saved";
}

@GetMapping(path="/all")
public @ResponseBody Iterable<Subscription> getAllSubscriptions() {
return subscriptionRepository.findAll();
}
	

}
