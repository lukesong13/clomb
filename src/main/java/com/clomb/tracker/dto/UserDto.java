package com.clomb.tracker.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String shoes;
    private String chalk;
    private int climbingGymId;
    private int routeId;

}

