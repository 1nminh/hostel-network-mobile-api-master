package com.giang.rest_api.impl;

import com.giang.rest_api.AuthencationApi;
import com.giang.service.UserService;
import com.giang.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthencationController implements AuthencationApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDTO> checkLogin(String username, String password) {
        UserDTO userDTO = userService.findByUsernameAndPassword(username, password);
        return ResponseEntity.ok(userDTO);
    }
}
