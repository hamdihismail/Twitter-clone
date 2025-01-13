package com.example.twitter_clone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.twitter_clone.model.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>  {
	
	Optional<Message> findByUserIdAndContent(Long userId, String Content);
	
	List<Message> findByUserId(Long userId);

	
	@Query("SELECT m FROM Message m JOIN Subscription s ON m.userId = s.producerId WHERE s.subscriberId = :id")
	List<Message> findMessagesBySubscriberId(@Param("id") Long id);
	

}
