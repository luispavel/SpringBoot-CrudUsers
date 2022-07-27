package com.crudusuarios.domain.service;

import com.crudusuarios.domain.User;
import com.crudusuarios.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.getAll();
	}
	public Optional<User> getUserById(long userId) {
		return userRepository.getUserById(userId);
	}
	public Optional<List<User>> getByName(String name) {
		return userRepository.getByName(name);
	}
	public Optional<List<User>> getByLastName(String lastName) {
		return userRepository.getByLastName(lastName);
	}
	public User save(User user) {
		return userRepository.save(user);
	}
	public boolean delete(Long userId) {
		return getUserById(userId).map(user -> {
			userRepository.delete(userId);
			return true;
		}).orElse(false);
	}

	public User update(User user) {
		return getUserById(user.getUserId()).map(userUpdate -> {
			userUpdate.setName(user.getName());
			userUpdate.setLastName(user.getLastName());
			userUpdate.setEmail(user.getEmail());
			userUpdate.setCellphone(user.getCellphone());
			userUpdate.setAddress(user.getAddress());
			userUpdate.setEmail(user.getEmail());
			return userRepository.update(userUpdate);
		}).orElse(null);
	}


}
