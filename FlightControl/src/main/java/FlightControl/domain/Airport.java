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
public class Airport {
    private String code;
    
    public Airport(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
}
