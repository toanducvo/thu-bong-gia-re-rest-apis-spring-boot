package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IUserService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.impl.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@PostMapping(value = "/users", consumes = MediaType.ALL_VALUE)
	public UserDTO addUser(@RequestBody UserDTO model) {
		return userService.addUser(model);
	}
	
	
	@GetMapping(value = "/users", consumes = MediaType.ALL_VALUE)
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public UserDTO getUser(@PathVariable long userId) {
		UserDTO userDTO = userService.getUser(userId);
		return userDTO;
	}
	
	@PutMapping(value = "/users", consumes = MediaType.ALL_VALUE)
	public void updateUser(@RequestBody UserDTO model) {
		userService.updateUser(model);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable long userId) {
		userService.deleteUser(userId);
	}
	
}
