package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.RouteDto;
import com.clomb.tracker.entities.Route;
import com.clomb.tracker.mapper.RouteMapper;
import com.clomb.tracker.repositories.RouteRepository;
import com.clomb.tracker.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;


    @Override
    public RouteDto createRoute(RouteDto routeDto) {
        Route route = routeMapper.mapToRoute(routeDto);
        Route savedRoute = routeRepository.save(route);

        return routeMapper.mapToRouteDto(savedRoute);
    }

    @Override
    public RouteDto getRouteById(int id) {
        return null;
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        return List.of();
    }

    @Override
    public RouteDto updateRoute(int id, RouteDto routeDto) {
        return null;
    }

    @Override
    public String deleteRouteById(int id) {
        return "";
    }

//    @Override
//    public GymDto getGymById(int id) {
//        Gym gym = gymRepository.
//                findById(id).
//                orElseThrow(() -> new RuntimeException("Gym of this ID does not exist"));
//        return gymMapper.mapToGymDto(gym);
//    }
//
//    @Override
//    public List<GymDto> getAllGyms() {
//        List<Gym> gyms = gymRepository.findAll();
//        List<GymDto> gymDtos = gyms.stream().map(gymMapper::mapToGymDto).collect(Collectors.toList());
//        return gymDtos;
//    }
//
//    @Override
//    public GymDto updateGym(int id, GymDto gymDto) {
//        Gym gym = gymRepository.findById(id).
//                orElseThrow( () -> new RuntimeException("User of this ID does not exist"));
//
//        gym.setGymName(gymDto.getGymName());
//        gym.setGymAddress(gymDto.getGymAddress());
//        gym.setGymCreateDate(gymDto.getGymCreateDate());
//        gym.setGymUpdateDate(gymDto.getGymUpdateDate());
//
//        Gym savedGym = gymRepository.save(gym);
//        return gymMapper.mapToGymDto(savedGym);
//    }
//
//    @Override
//    public String deleteGymById(int id) {
//        if(gymRepository.existsById(id)){
//            gymRepository.deleteById((id));
//            return "Successfully deleted gym with id "+ id;
//        } else{
//            return "no record of gym with id "+ id;
//        }
//    }
//
//


}
