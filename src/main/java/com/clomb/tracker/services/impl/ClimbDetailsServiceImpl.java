package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.ClimbDetailsDto;
import com.clomb.tracker.entities.ClimbDetails;
import com.clomb.tracker.mapper.ClimbDetailsMapper;
import com.clomb.tracker.repositories.ClimbDetailsRepository;
import com.clomb.tracker.services.ClimbDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClimbDetailsServiceImpl implements ClimbDetailsService {

    @Autowired
    private ClimbDetailsRepository climbDetailsRepository;

    @Autowired
    private ClimbDetailsMapper climbDetailsMapper;


    @Override
    public ClimbDetailsDto createClimbDetails(ClimbDetailsDto climbDetailsDto) {
        ClimbDetails climbDetails = climbDetailsMapper.mapToClimbDetails(climbDetailsDto);
        ClimbDetails savedClimbDetails = climbDetailsRepository.save(climbDetails);

        return climbDetailsMapper.mapToClimbDetailsDto(savedClimbDetails);
    }

    @Override
    public ClimbDetailsDto getClimbDetailsById(int id) {
        return null;
    }

    @Override
    public List<ClimbDetailsDto> getAllClimbDetails() {
        return List.of();
    }

    @Override
    public ClimbDetailsDto updateClimbDetails(int id, ClimbDetailsDto climbdetailsDto) {
        return null;
    }

    @Override
    public String deleteClimbDetailsById(int id) {
        return "";
    }
//
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



}
