package com.giang.rest_api.impl;

import com.giang.rest_api.UserApi;
import com.giang.service.UserService;
import com.giang.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<UserDTO> updateInformation(@PathVariable("id") Integer id,
                                                     @RequestBody UserDTO updateDTO) {
        return ResponseEntity.ok(userService.updateInformation(updateDTO));
    }

    @Override
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO newUser) {
        return ResponseEntity.ok(userService.createNewUser(newUser));
    }
}
