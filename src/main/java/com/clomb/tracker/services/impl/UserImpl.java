package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.UserDto;
import com.clomb.tracker.entities.User;
import com.clomb.tracker.mapper.UserMapper;
import com.clomb.tracker.repositories.UserRepository;
import com.clomb.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserDto getUser(int id) {
        return null;
    }

    @Override
    public UserDto updateUser(int id) {
        return null;
    }

    @Override
    public UserDto deleteUser(int id) {
        return null;
    }
}
