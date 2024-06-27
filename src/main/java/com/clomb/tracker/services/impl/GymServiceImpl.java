package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.GymDto;
import com.clomb.tracker.entities.Gym;
import com.clomb.tracker.mapper.GymMapper;
import com.clomb.tracker.repositories.GymRepository;
import com.clomb.tracker.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    private GymRepository gymRepository;

    @Autowired
    private GymMapper gymMapper;


    @Override
    public GymDto createGym(GymDto gymDto) {
        Gym gym = gymMapper.mapToGym(gymDto);
        Gym savedGym = gymRepository.save(gym);

        return gymMapper.mapToGymDto(savedGym);
    }

    @Override
    public GymDto getGymById(int id) {
        return null;
    }

    @Override
    public List<GymDto> getAllGyms() {
        return List.of();
    }

    @Override
    public GymDto updateGym(int id, GymDto gymDto) {
        return null;
    }

    @Override
    public String deleteGymById(int id) {
        return "";
    }
}
