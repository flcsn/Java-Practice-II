/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

import java.util.ArrayList;

/**
 *
 * @author Frankie
 */
public class Airplane {
    private String id;
    private int capacity;
    private ArrayList<Flight> flights;
    
    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.flights = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public ArrayList<Flight> getFlights() {
        return flights;
    }
    
    public String toString() {
        return "Airplane " + this.id;
    }
    
}
