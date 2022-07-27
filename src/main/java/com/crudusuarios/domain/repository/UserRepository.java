package com.crudusuarios.domain.repository;

import com.crudusuarios.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	List<User> getAll();
	Optional<User> getUserById(long userId);
	Optional<List<User>> getByName(String name);
	Optional<List<User>> getByLastName(String lastName);
	User save(User user);
	void delete(Long userId);
	User update(User user);
}
