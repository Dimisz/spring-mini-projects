package com.uningen.PlaneFinder.web;

import com.uningen.PlaneFinder.domain.Aircraft;
import com.uningen.PlaneFinder.domain.AircraftRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    private final AircraftRepository aircraftRepository;

    public AircraftController(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    @GetMapping
    Iterable<Aircraft> getAircraft(){
        return aircraftRepository.findAll();
    }
}
