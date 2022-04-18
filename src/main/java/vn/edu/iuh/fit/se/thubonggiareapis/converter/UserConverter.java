package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;

public class UserConverter {
	public User toUserEntity(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setPassword(userDTO.getPassword());
		
		return user;
	}
	
	public UserDTO toUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setPassword(userDTO.getPassword());
		
		return userDTO;
	}
}
