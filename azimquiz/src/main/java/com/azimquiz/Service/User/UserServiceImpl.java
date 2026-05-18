package com.azimquiz.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azimquiz.entities.User;
import com.azimquiz.enums.UserRole;
import com.azimquiz.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	@PostConstruct
	private void createAdminUser() {
		
		User optionalUser = userRepository.findByRole(UserRole.ADMIN);
		if(optionalUser == null) {
			User user = new User();
			user.setName("Admin");
			user.setEmail("admin@gmail.com");
			user.setRole(UserRole.ADMIN);
			user.setPassword("admin");	
			userRepository.save(user);
		}
	}
	
	public Boolean hasUserWithEmail(String email) {
		return  userRepository.findFirstByEmail(email) != null;
	}
	
	public User createUser(User user) {
		user.setRole(UserRole.USER);
		return userRepository.save(user);
	}
	

}

