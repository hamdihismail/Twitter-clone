package org.ac.cst8277.ismail.hamdi.ums.service;


import org.ac.cst8277.ismail.hamdi.ums.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	private final UserRepository repository;
	
	
	
	public UserDetailsServiceImp(UserRepository repository) {
		this.repository = repository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}

}
