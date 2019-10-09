package com.giang.rest_api;

import com.giang.service.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/authentication")
public interface AuthencationApi {

    @ApiOperation(tags = {"AUTHENTICATION"}, response = UserDTO.class, value = "Check login")
    @GetMapping("")
    ResponseEntity<UserDTO> checkLogin(@RequestParam("username") String username,
                                       @RequestParam("password") String password);
}
