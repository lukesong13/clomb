package com.clomb.tracker.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GymDto {

    private int id;
    private String gymName;
    private String gymAddress;
    private String gymCreateDate;
    private String gymUpdateDate;

}


