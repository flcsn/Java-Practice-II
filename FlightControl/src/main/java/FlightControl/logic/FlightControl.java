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
    private ArrayList<Flight> flights;
    private HashMap<String, Airport> airports;
    
    public FlightControl() {
        this.planes = new HashMap<>();
        this.flights = new ArrayList<>();
        this.airports = new HashMap<>();
    }
    
    public void addAirplane(String id, int capacity) {
        Airplane newPlane = new Airplane(id, capacity);
        planes.putIfAbsent(id, newPlane);
    }
    
    public void addFlight(String planeId, String placeOfDeparture, String placeOfArrival) {
        this.airports.putIfAbsent(placeOfDeparture, new Airport(placeOfDeparture));
        this.airports.putIfAbsent(placeOfArrival, new Airport(placeOfArrival));
        
        this.flights.add(new Flight(this.planes.get(planeId), this.airports.get(placeOfDeparture), this.airports.get(placeOfArrival)));
    }
    
    public boolean checkIfAirplaneExists(String id) {
        for (String planeId : planes.keySet()) {
            if (id.equals(planeId)) {
                return true;
            }
        }
        return false;
    }
    
    public void printAirplanes() {
        planes.values().stream()
                .forEach(plane -> System.out.println(plane));
    }
    
    public void printFlights() {
        flights.stream()
                .forEach(flight -> System.out.println(flight));
    }
    
    public void printOneAirplane(String id) {
        System.out.println(planes.get(id));
    }
    
    
    
    
    
}
