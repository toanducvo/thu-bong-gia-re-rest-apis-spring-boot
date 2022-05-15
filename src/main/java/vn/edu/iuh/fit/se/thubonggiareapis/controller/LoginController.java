package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPasswordService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IUserService;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/creds")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private IPasswordService passwordService;

    @Autowired
    private IUserService userService;

    @PostMapping(value = {
            "", "/"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody HashMap<String, Object> creds) {
        HashMap<String, Object> response = new HashMap<>();
        try {
            UserDTO userDTO = userService.getUserByEmail(creds.get("email").toString());

            if (!Objects.isNull(userDTO)) {
                if (passwordService.checkPassword(creds.get("password").toString(), userDTO.getPassword())) {
                    response.put("userId", userDTO.getId());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }

                response.put("message", "Email or Password does not match on our server");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.put("message", "Email or Password does not match on our server");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
