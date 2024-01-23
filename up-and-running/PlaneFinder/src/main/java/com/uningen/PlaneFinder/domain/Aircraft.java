package com.uningen.PlaneFinder.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.Random;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String callsign, squawk, reg, flightno, route, type, category;
    private int altitude, heading, speed;
    private double lat, lon;
    private int barometer, vert_rate, selected_altitude;
    private double polar_distance, polar_bearing;
    private boolean is_adsb, is_on_ground;
    private Instant last_seen_time, pos_update_time, bds40_seen_time;

    public Aircraft() {
    }

    public Aircraft(String callsign, String squawk, String reg, String flightno, String route, String type, String category, int altitude, int heading, int speed, double lat, double lon, int barometer, int vert_rate, int selected_altitude, double polar_distance, double polar_bearing, boolean is_adsb, boolean is_on_ground, Instant last_seen_time, Instant pos_update_time, Instant bds40_seen_time) {
        this.callsign = callsign;
        this.squawk = squawk;
        this.reg = reg;
        this.flightno = flightno;
        this.route = route;
        this.type = type;
        this.category = category;
        this.altitude = altitude;
        this.heading = heading;
        this.speed = speed;
        this.lat = lat;
        this.lon = lon;
        this.barometer = barometer;
        this.vert_rate = vert_rate;
        this.selected_altitude = selected_altitude;
        this.polar_distance = polar_distance;
        this.polar_bearing = polar_bearing;
        this.is_adsb = is_adsb;
        this.is_on_ground = is_on_ground;
        this.last_seen_time = last_seen_time;
        this.pos_update_time = pos_update_time;
        this.bds40_seen_time = bds40_seen_time;
    }

    public Aircraft(String callsign, String squawk, String reg, String flightno, String route, String type, String category){
        this(callsign, squawk, reg, flightno, route, type, category, new Random().nextInt(), new Random().nextInt(), new Random().nextInt(), new Random().nextDouble(),
                new Random().nextDouble(), new Random().nextInt(), new Random().nextInt(), new Random().nextInt(), new Random().nextDouble(),
                new Random().nextDouble(), new Random().nextBoolean(), new Random().nextBoolean(),
                Instant.now().minusSeconds(new Random().nextLong(10000)), Instant.now().minusSeconds(new Random().nextLong(10000)), Instant.now().minusSeconds(new Random().nextLong(10000)));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getSquawk() {
        return squawk;
    }

    public void setSquawk(String squawk) {
        this.squawk = squawk;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getBarometer() {
        return barometer;
    }

    public void setBarometer(int barometer) {
        this.barometer = barometer;
    }

    public int getVert_rate() {
        return vert_rate;
    }

    public void setVert_rate(int vert_rate) {
        this.vert_rate = vert_rate;
    }

    public int getSelected_altitude() {
        return selected_altitude;
    }

    public void setSelected_altitude(int selected_altitude) {
        this.selected_altitude = selected_altitude;
    }

    public double getPolar_distance() {
        return polar_distance;
    }

    public void setPolar_distance(double polar_distance) {
        this.polar_distance = polar_distance;
    }

    public double getPolar_bearing() {
        return polar_bearing;
    }

    public void setPolar_bearing(double polar_bearing) {
        this.polar_bearing = polar_bearing;
    }

    public boolean isIs_adsb() {
        return is_adsb;
    }

    public void setIs_adsb(boolean is_adsb) {
        this.is_adsb = is_adsb;
    }

    public boolean isIs_on_ground() {
        return is_on_ground;
    }

    public void setIs_on_ground(boolean is_on_ground) {
        this.is_on_ground = is_on_ground;
    }

    public Instant getLast_seen_time() {
        return last_seen_time;
    }

    public void setLast_seen_time(Instant last_seen_time) {
        this.last_seen_time = last_seen_time;
    }

    public Instant getPos_update_time() {
        return pos_update_time;
    }

    public void setPos_update_time(Instant pos_update_time) {
        this.pos_update_time = pos_update_time;
    }

    public Instant getBds40_seen_time() {
        return bds40_seen_time;
    }

    public void setBds40_seen_time(Instant bds40_seen_time) {
        this.bds40_seen_time = bds40_seen_time;
    }
}
