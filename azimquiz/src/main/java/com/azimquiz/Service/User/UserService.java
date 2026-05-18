package com.azimquiz.Service.User;

import com.azimquiz.entities.User;

public interface UserService {
	User createUser(User user);
	Boolean hasUserWithEmail(String email);
}
