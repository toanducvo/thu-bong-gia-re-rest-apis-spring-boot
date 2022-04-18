package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;

@Service
public interface IUserService {
	UserDTO addUser(UserDTO userDTO);
}
