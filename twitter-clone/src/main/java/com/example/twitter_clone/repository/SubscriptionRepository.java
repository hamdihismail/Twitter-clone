package com.example.twitter_clone.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.twitter_clone.model.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

}
