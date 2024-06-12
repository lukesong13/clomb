package com.clomb.tracker.services;

import com.clomb.tracker.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto UserDto);
    UserDto getUser(int id);
    UserDto updateUser(int id);
    UserDto deleteUser(int id);


    /*
    create new user
    get user
    update user
    delete user



     */


}
