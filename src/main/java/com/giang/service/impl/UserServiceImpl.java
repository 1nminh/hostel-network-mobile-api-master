package com.giang.service.impl;

import com.giang.repository.UserRepository;
import com.giang.repository.entity.User;
import com.giang.service.UserService;
import com.giang.service.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByPhoneAndPassword(username, password);
        Optional.ofNullable(user).orElseThrow(EntityNotFoundException::new);
        return this.mapToDto(user);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id);
        Optional.ofNullable(user).orElseThrow(EntityNotFoundException::new);
        return this.mapToDto(user);
    }

    @Override
    public UserDTO updateInformation(UserDTO updateDTO) {
        User user = userRepository.findById(updateDTO.getId());
        Optional.ofNullable(user).orElseThrow(EntityNotFoundException::new);

        User updateUser = mapToEntity(updateDTO);
        user = userRepository.saveAndFlush(updateUser);

        return mapToDto(user);
    }

    @Override
    public UserDTO createNewUser(UserDTO newUser) {
        User user = userRepository.findByPhone(newUser.getPhone());
        if (Objects.nonNull(user)){
            throw new EntityExistsException("This username is existed! ");
        }
        user = userRepository.saveAndFlush(mapToEntity(newUser));
        return mapToDto(user);
    }


    private UserDTO mapToDto(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, UserDTO.class);
    }

    private User mapToEntity(UserDTO entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, User.class);
    }
}
