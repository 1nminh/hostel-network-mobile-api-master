package com.giang.rest_api;

import com.giang.service.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("/users")
public interface UserApi {

    @ApiOperation(tags = {"USER"}, response = UserDTO.class, value = "Get user by Id")
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id);

    @ApiOperation(tags = {"USER"}, response = UserDTO.class, value = "Update information user")
    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateInformation(@PathVariable("id") Integer id,
                                              @RequestBody UserDTO updateDTO);

    @ApiOperation(tags = {"USER"}, response = UserDTO.class, value = "Create new user")
    @PostMapping("")
    ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO newUser);

}
