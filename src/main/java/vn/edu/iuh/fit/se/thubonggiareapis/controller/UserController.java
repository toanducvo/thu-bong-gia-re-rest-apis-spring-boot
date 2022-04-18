package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
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
}
