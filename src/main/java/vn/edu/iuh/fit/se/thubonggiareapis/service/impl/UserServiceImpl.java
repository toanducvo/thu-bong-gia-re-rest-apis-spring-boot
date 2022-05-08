package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.se.thubonggiareapis.converter.UserConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.UserRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User user = userConverter.toUserEntity(userDTO);
		user = userRepository.save(user);
		return userConverter.toUserDTO(user);
	}

	@Override
	public List<UserDTO> getUsers() {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<User> users = userRepository.findAll();
		for(User user: users) {
			UserDTO userDTO = userConverter.toUserDTO(user);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	@Override
	public UserDTO getUser(long id) {
		User user = userRepository.getById(id);
		UserDTO userDTO = userConverter.toUserDTO(user);
		return userDTO;
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		User user = userConverter.toUserEntity(userDTO);
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
		
	}
	 
	

}
