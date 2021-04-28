/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import java.util.HashMap;
import java.util.ArrayList;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Airport;

/**
 *
 * @author Frankie
 */
public class FlightControl {
    private HashMap<String, Airplane> planes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Airport> airports;
    
    public FlightControl() {
        this.planes = new HashMap<>();
        this.flights = new HashMap<>();
        this.airports = new HashMap<>();
    }
    
    public void addAirplane(String id, int capacity) {
        Airplane newPlane = new Airplane(id, capacity);
        planes.putIfAbsent(id, newPlane);
    }
    
    public void addFlight(String id, String placeOfDeparture, String placeOfArrival) {
        this.airports.putIfAbsent(placeOfDeparture, new Airport(placeOfDeparture));
        this.airports.putIfAbsent(placeOfArrival, new Airport(placeOfArrival));
        
        this.flights.put(id, new Flight(this.planes.get(id), this.airports.get(placeOfDeparture), this.airports.get(placeOfArrival)));
    }
    
    public boolean checkIfAirplaneExists(String id) {
        for (Airplane plane : planes.values()) {
            if (id.equals(plane.getId())) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
}
