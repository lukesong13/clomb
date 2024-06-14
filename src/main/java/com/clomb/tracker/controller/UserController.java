package com.clomb.tracker.controller;

import com.clomb.tracker.dto.UserDto;
import com.clomb.tracker.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }
    /*
    ResponseEntity extends HttpEntity. HttpEntity is handles requests and responses over HTTP
    @RequestBody maps the JSON in the request body to the productDto.
    In the return statement, we are than passing that productDto object to the productService.createProduct()
    method.
     */

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserById(id);
                return ResponseEntity.ok(userDto);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        String status = userService.deleteUserById(id);
        return ResponseEntity.ok(status);
    }

}
