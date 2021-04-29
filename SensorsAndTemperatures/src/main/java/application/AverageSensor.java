/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frankie
 */
public class AverageSensor implements Sensor{
    private ArrayList<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                return false;
            }
        }
        return true;
    }    
    
    public void setOn() {
        sensors.stream()
                .forEach(sensor -> sensor.setOn());
    }      
    
    public void setOff() {
        sensors.stream()
                .forEach(sensor -> sensor.setOff());
    }     
    
    public int read() {
        if (!(this.isOn())) {
            throw new IllegalStateException("The AverageSensor is not on.");
        }
        
        double reading = sensors.stream()
                .mapToInt(sensor -> sensor.read())
                .average()
                .getAsDouble();
        
        int reading2 = (int) reading;
        
        readings.add(reading2);
        return reading2;
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return readings;
    }
}

