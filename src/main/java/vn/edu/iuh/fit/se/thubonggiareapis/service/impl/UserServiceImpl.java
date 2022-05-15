package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.UserConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.UserRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPasswordService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IPasswordService passwordService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userConverter.toEntity(userDTO);
        user.setPassword(passwordService.passwordEncoder().encode(user.getPassword()));
        user = userRepository.save(user);
        return userConverter.toDto(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOs = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            UserDTO userDTO = userConverter.toDto(user);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public UserDTO getUser(long id) {
        User user = userRepository.findById(id).orElse(null);
        if (Objects.isNull(user)) {
            return null;
        }
        return userConverter.toDto(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userConverter.toEntity(userDTO);
        userRepository.save(user);

    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }


}
