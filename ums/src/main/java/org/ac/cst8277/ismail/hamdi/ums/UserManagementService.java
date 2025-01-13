package org.ac.cst8277.ismail.hamdi.ums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.ac.cst8277.ismail.hamdi.ums.model.Role;
import org.ac.cst8277.ismail.hamdi.ums.model.User;
import org.ac.cst8277.ismail.hamdi.ums.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementService implements CommandLineRunner{
	
	
	@Autowired UserRepository ob;

	public static void main(String[] args) {
		SpringApplication.run(UserManagementService.class, args);
		System.out.print("Hello World");
	}
	@Override
	public void run(String... args) throws Exception
    {
//         Inserting the test data in the mysql table.
		List<User> initialUsers = Arrays.asList(
	            new User("TesterPro", "producer@example.com", Role.PRODUCER, "password"),
	            new User("TesterAdmin", "admin@example.com", Role.ADMIN, "password"),
	            new User("TesterSub", "subscriber@example.com", Role.PRODUCER, "password")
	        );
//		
		for (User user : initialUsers) {
            Optional<User> existingUser = ob.findByUsername(user.getUsername());
            if (existingUser.isPresent()) {
                System.out.println("Initial user " + user.getUsername() + " already present");
            } else {
                ob.save(user);
                System.out.println("User " + user.getUsername() + " created successfully");
            }
        }

    }

}
