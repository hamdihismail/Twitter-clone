package org.ac.cst8277.ismail.hamdi.ums.repository;

import java.util.Optional; 

import org.ac.cst8277.ismail.hamdi.ums.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	
	Optional<User> findById(Long id);
	
	
	void deleteById(Long id);
	
	
}
