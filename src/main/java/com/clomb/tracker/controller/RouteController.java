package com.clomb.tracker.controller;

import com.clomb.tracker.dto.RouteDto;
import com.clomb.tracker.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    @PostMapping
    public ResponseEntity<RouteDto> addRoute(@RequestBody RouteDto routeDto){
        return new ResponseEntity<>(routeService.createRoute(routeDto), HttpStatus.CREATED);
    }

//    /*
//    ResponseEntity extends HttpEntity. HttpEntity is handles requests and responses over HTTP
//    @RequestBody maps the JSON in the request body to the productDto.
//    In the return statement, we are than passing that productDto object to the productService.createProduct()
//    method.
//     */
////
//    @GetMapping("/{id}")
//    public ResponseEntity<GymDto> getGymById(@PathVariable int id) {
//        GymDto gymDto = gymService.getGymById(id);
//                return ResponseEntity.ok(gymDto);
//
//    }
//
//    @GetMapping
//    public ResponseEntity<List<GymDto>> getAllUsers() {
//        List<GymDto> gyms = gymService.getAllGyms();
//        return ResponseEntity.ok(gyms);
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteGymById(@PathVariable int id) {
//         String status = gymService.deleteGymById(id);
//        return ResponseEntity.ok(status);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<GymDto> updateUser(@PathVariable int id, @RequestBody Map<String, String> request){
//        String gymName = request.get("gymName");
//        String gymAddress = request.get("gymAddress");
//        String gymCreateDate = null;
//        String gymUpdateDate = request.get("gymUpdateDate");
//
//        GymDto gymDtoFromRequest = new GymDto(
//                id,
//                gymName,
//                gymAddress,
//               gymCreateDate,
//               gymUpdateDate);
//
//        GymDto gymDto = gymService.updateGym(id,gymDtoFromRequest);
//
//        return ResponseEntity.ok(gymDto);
//    }
//
}
