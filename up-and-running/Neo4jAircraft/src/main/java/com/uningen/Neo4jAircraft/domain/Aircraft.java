package com.uningen.Neo4jAircraft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.Instant;

@Node
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {
    @Id
    @GeneratedValue
    private Long neoId;

    private Long id;
    private String callsign, squawk, reg, flightno, route, type, category;
    private int altitude, heading, speed;
    @JsonProperty("vert_rate")
    private int vertRate;
    @JsonProperty("selected_altitude")
    private int selectedAltitude;

    private double lat, lon, barometer;
    @JsonProperty("polar_distance")
    private double polarDistance;
    @JsonProperty("polar_bearing")
    private double polarBearing;

    @JsonProperty("is_adsb")
    private boolean isADSB;
    @JsonProperty("is_on_ground")
    private boolean isOnGround;

    @JsonProperty("last_seen_time")
    private Instant lastSeenTime;
    @JsonProperty("pos_update_time")
    private Instant posUpdateTime;
    @JsonProperty("bds40_seen_time")
    private Instant bds40SeenTime;

    public Aircraft() {
    }

    public Aircraft(Long id, String callsign, String squawk, String reg, String flightno, String route, String type, String category, int altitude, int heading, int speed, int vertRate, int selectedAltitude, double lat, double lon, double barometer, double polarDistance, double polarBearing, boolean isADSB, boolean isOnGround, Instant lastSeenTime, Instant posUpdateTime, Instant bds40SeenTime) {
        this.id = id;
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
        this.vertRate = vertRate;
        this.selectedAltitude = selectedAltitude;
        this.lat = lat;
        this.lon = lon;
        this.barometer = barometer;
        this.polarDistance = polarDistance;
        this.polarBearing = polarBearing;
        this.isADSB = isADSB;
        this.isOnGround = isOnGround;
        this.lastSeenTime = lastSeenTime;
        this.posUpdateTime = posUpdateTime;
        this.bds40SeenTime = bds40SeenTime;
    }

    public Long getNeoId() {
        return neoId;
    }

    public void setNeoId(Long neoId) {
        this.neoId = neoId;
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

    public int getVertRate() {
        return vertRate;
    }

    public void setVertRate(int vertRate) {
        this.vertRate = vertRate;
    }

    public int getSelectedAltitude() {
        return selectedAltitude;
    }

    public void setSelectedAltitude(int selectedAltitude) {
        this.selectedAltitude = selectedAltitude;
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

    public double getBarometer() {
        return barometer;
    }

    public void setBarometer(double barometer) {
        this.barometer = barometer;
    }

    public double getPolarDistance() {
        return polarDistance;
    }

    public void setPolarDistance(double polarDistance) {
        this.polarDistance = polarDistance;
    }

    public double getPolarBearing() {
        return polarBearing;
    }

    public void setPolarBearing(double polarBearing) {
        this.polarBearing = polarBearing;
    }

    public boolean isADSB() {
        return isADSB;
    }

    public void setADSB(boolean ADSB) {
        isADSB = ADSB;
    }

    public boolean isOnGround() {
        return isOnGround;
    }

    public void setOnGround(boolean onGround) {
        isOnGround = onGround;
    }

    public Instant getLastSeenTime() {
        return lastSeenTime;
    }

    public void setLastSeenTime(Instant lastSeenTime) {
        this.lastSeenTime = lastSeenTime;
    }

    public Instant getPosUpdateTime() {
        return posUpdateTime;
    }

    public void setPosUpdateTime(Instant posUpdateTime) {
        this.posUpdateTime = posUpdateTime;
    }

    public Instant getBds40SeenTime() {
        return bds40SeenTime;
    }

    public void setBds40SeenTime(Instant bds40SeenTime) {
        this.bds40SeenTime = bds40SeenTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft aircraft)) return false;

        if (getAltitude() != aircraft.getAltitude()) return false;
        if (getHeading() != aircraft.getHeading()) return false;
        if (getSpeed() != aircraft.getSpeed()) return false;
        if (getVertRate() != aircraft.getVertRate()) return false;
        if (getSelectedAltitude() != aircraft.getSelectedAltitude()) return false;
        if (Double.compare(aircraft.getLat(), getLat()) != 0) return false;
        if (Double.compare(aircraft.getLon(), getLon()) != 0) return false;
        if (Double.compare(aircraft.getBarometer(), getBarometer()) != 0) return false;
        if (Double.compare(aircraft.getPolarDistance(), getPolarDistance()) != 0) return false;
        if (Double.compare(aircraft.getPolarBearing(), getPolarBearing()) != 0) return false;
        if (isADSB() != aircraft.isADSB()) return false;
        if (isOnGround() != aircraft.isOnGround()) return false;
        if (!getNeoId().equals(aircraft.getNeoId())) return false;
        if (!getId().equals(aircraft.getId())) return false;
        if (!getCallsign().equals(aircraft.getCallsign())) return false;
        if (!getSquawk().equals(aircraft.getSquawk())) return false;
        if (!getReg().equals(aircraft.getReg())) return false;
        if (!getFlightno().equals(aircraft.getFlightno())) return false;
        if (!getRoute().equals(aircraft.getRoute())) return false;
        if (!getType().equals(aircraft.getType())) return false;
        if (!getCategory().equals(aircraft.getCategory())) return false;
        if (!getLastSeenTime().equals(aircraft.getLastSeenTime())) return false;
        if (!getPosUpdateTime().equals(aircraft.getPosUpdateTime())) return false;
        return getBds40SeenTime().equals(aircraft.getBds40SeenTime());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getNeoId().hashCode();
        result = 31 * result + getId().hashCode();
        result = 31 * result + getCallsign().hashCode();
        result = 31 * result + getSquawk().hashCode();
        result = 31 * result + getReg().hashCode();
        result = 31 * result + getFlightno().hashCode();
        result = 31 * result + getRoute().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getAltitude();
        result = 31 * result + getHeading();
        result = 31 * result + getSpeed();
        result = 31 * result + getVertRate();
        result = 31 * result + getSelectedAltitude();
        temp = Double.doubleToLongBits(getLat());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLon());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getBarometer());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPolarDistance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPolarBearing());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isADSB() ? 1 : 0);
        result = 31 * result + (isOnGround() ? 1 : 0);
        result = 31 * result + getLastSeenTime().hashCode();
        result = 31 * result + getPosUpdateTime().hashCode();
        result = 31 * result + getBds40SeenTime().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "neoId=" + neoId +
                ", id=" + id +
                ", callsign='" + callsign + '\'' +
                ", squawk='" + squawk + '\'' +
                ", reg='" + reg + '\'' +
                ", flightno='" + flightno + '\'' +
                ", route='" + route + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", altitude=" + altitude +
                ", heading=" + heading +
                ", speed=" + speed +
                ", vertRate=" + vertRate +
                ", selectedAltitude=" + selectedAltitude +
                ", lat=" + lat +
                ", lon=" + lon +
                ", barometer=" + barometer +
                ", polarDistance=" + polarDistance +
                ", polarBearing=" + polarBearing +
                ", isADSB=" + isADSB +
                ", isOnGround=" + isOnGround +
                ", lastSeenTime=" + lastSeenTime +
                ", posUpdateTime=" + posUpdateTime +
                ", bds40SeenTime=" + bds40SeenTime +
                '}';
    }
}
