package com.uningen.Neo4jAircraft.web;

import com.uningen.Neo4jAircraft.domain.Aircraft;
import com.uningen.Neo4jAircraft.domain.AircraftRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {
    private WebClient webClient =
            WebClient.create("http://localhost:7634/aircraft");
    private final AircraftRepository aircraftRepository;

    public PlaneFinderPoller(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    @Scheduled(fixedRate = 1000)
    private void pollPlanes(){
        aircraftRepository.deleteAll();
        webClient.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream()
                .forEach(aircraftRepository::save);
        System.out.println("---- All Aircraft ---- ");
        aircraftRepository.findAll().forEach(System.out::println);
    }
}
