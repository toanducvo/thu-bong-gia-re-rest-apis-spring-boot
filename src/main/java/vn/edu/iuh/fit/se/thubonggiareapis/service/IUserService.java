package vn.edu.iuh.fit.se.thubonggiareapis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;

@Service
public interface IUserService {
	UserDTO addUser(UserDTO userDTO);
	List<UserDTO> getUsers();
	UserDTO getUser(long id);
	void updateUser(UserDTO userDTO);
	void deleteUser(long id);
}
