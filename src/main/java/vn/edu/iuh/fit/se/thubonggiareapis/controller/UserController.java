package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = {
            "", "/"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public UserDTO addUser(@RequestBody UserDTO model) {
        return userService.addUser(model);
    }


    @GetMapping(value = {
            "", "/"
    })
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable long userId) {
        return userService.getUser(userId);
    }

    @PutMapping(value = {
            "", "/"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public void updateUser(@RequestBody UserDTO model) {
        userService.updateUser(model);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }

}
