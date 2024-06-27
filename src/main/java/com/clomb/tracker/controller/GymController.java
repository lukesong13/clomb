package com.clomb.tracker.controller;

import com.clomb.tracker.dto.GymDto;
import com.clomb.tracker.services.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }
    @PostMapping
    public ResponseEntity<GymDto> addUser(@RequestBody GymDto gymDto){
        return new ResponseEntity<>(gymService.createGym(gymDto), HttpStatus.CREATED);
    }

    /*
    ResponseEntity extends HttpEntity. HttpEntity is handles requests and responses over HTTP
    @RequestBody maps the JSON in the request body to the productDto.
    In the return statement, we are than passing that productDto object to the productService.createProduct()
    method.
     */
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
//        UserDto userDto = userService.getUserById(id);
//                return ResponseEntity.ok(userDto);
//
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UserDto>> getAllUsers() {
//        List<UserDto> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
//        String status = userService.deleteUserById(id);
//        return ResponseEntity.ok(status);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody Map<String, String> request){
//        String firstName = request.get("firstName");
//        String lastName = request.get("lastName");
//        String email = request.get("email");
//        String shoes = request.get("shoes");
//        String chalk = request.get("chalk");
//        String username = request.get("username");
//        String password = request.get("password");
//        String gender = request.get("gender");
//        String createDate = null;
//        String updateDate = request.get("updateDate");
//
//        UserDto userDtoFromRequest = new UserDto(
//                id,
//                firstName,
//                lastName,
//                email,
//                shoes,
//                chalk,
//                username,
//                password,
//                gender,
//                createDate,
//                updateDate);
//
//        UserDto userDto = userService.updateUser(id,userDtoFromRequest);
//
//        return ResponseEntity.ok(userDto);
//    }

}
