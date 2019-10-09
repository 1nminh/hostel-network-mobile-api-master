package com.giang.service;

import com.giang.service.dto.UserDTO;

public interface UserService {

    UserDTO findByUsernameAndPassword(String username, String password);

    UserDTO getUserById(Integer id);

    UserDTO updateInformation(UserDTO updateDTO);

    UserDTO createNewUser(UserDTO newUser);

}
