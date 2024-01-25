package com.uningen.PlaneFinder.domain;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class DataLoader {
    private final AircraftRepository aircraftRepository;

    public DataLoader(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }


    @PostConstruct
    private void loadData(){
        Random random = new Random();
//            public Aircraft(  , int selected_altitude, double polar_distance, double polar_bearing, boolean is_adsb, boolean is_on_ground, Instant last_seen_time, java.time.Instant
//        pos_update_time, java.time.Instant bds40_seen_time) {

            aircraftRepository.saveAll(List.of(
                new Aircraft("AMF4263", "4136", "N49UC", "N49UC", "LAN-DFN", "B190",
                        "A1"),
                new Aircraft("ABC4263", "4137", "J49UC", "N49UC", "LAN-DFN", "B190",
                        "A1"),
                new Aircraft("BCD4263", "2323", "HY89OO", "N49UC", "PKG-MSQ", "B190",
                        "A1")
        ));
    }
}
