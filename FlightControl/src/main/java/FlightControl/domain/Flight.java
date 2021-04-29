/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author Frankie
 */
public class Flight {
    private Airplane plane;
    private Airport placeOfDeparture;
    private Airport placeOfArrival;
    
    public Flight(Airplane plane, Airport placeOfDeparture, Airport placeOfArrival) {
        this.plane = plane;
        this.placeOfDeparture = placeOfDeparture;
        this.placeOfArrival = placeOfArrival;
    }
    
    public Airplane getAirplane() {
        return plane;
    }
    
    public Airport getPlaceOfDeparture() {
        return placeOfDeparture;
    }
    
    public Airport getPlaceOfArrival() {
        return placeOfArrival;
    }
    
    public String toString() {
        return this.plane + " (" + this.placeOfDeparture.getCode() + "-" + this.placeOfArrival.getCode() + ")";
    }
}
