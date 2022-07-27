package com.crudusuarios.web.controller;

import com.crudusuarios.domain.User;
import com.crudusuarios.domain.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/all")
	@ApiOperation("Get all users")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(userService.getAll(),
				HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@ApiOperation("Serch user by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found")
	})
	public ResponseEntity<User> getUserById(@ApiParam(value = "Id of user", required = true, example = "7")
												@PathVariable("id") long userId) {
		return userService.getUserById(userId)
				.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<List<User>> getByName(@PathVariable("name") String name) {
		return userService.getByName(name)
				.map(users -> new ResponseEntity<>(users, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/lastname/{lastname}")
	public ResponseEntity<List<User>> getByLastName(@PathVariable("lastname") String lastName) {
		return userService.getByLastName(lastName)
				.map(users -> new ResponseEntity<>(users, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user) {
		return new ResponseEntity<>(userService.save(user),
				HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") long userId) {
		if (userService.delete(userId)) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user) {
		return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
	}

}
