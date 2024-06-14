package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.UserDto;
import com.clomb.tracker.entities.User;
import com.clomb.tracker.mapper.UserMapper;
import com.clomb.tracker.repositories.UserRepository;
import com.clomb.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto UserDto) {
        User user = userMapper.mapToUser(UserDto);
        User savedUser = userRepository.save(user);

        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User of this ID does not exist"));
        return userMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(userMapper::mapToUserDto).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto updateUser(int id) {
        return null;
    }

    @Override
    public String deleteUserById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Successfully deleted user with id " + id;
        } else {
            return "no record of user with id " + id;
        }
    }

}


