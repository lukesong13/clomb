package com.clomb.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RouteDto {

    private int id;
    private String grade;
    private String setter;
    private String color;
    private int gymId;
    private String routeCreateDate;
    private String routeUpdateDate;

}


