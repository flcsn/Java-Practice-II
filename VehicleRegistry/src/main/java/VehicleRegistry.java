/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate,String> carOwners;
    
    public VehicleRegistry() {
        this.carOwners = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.inRegistry(licensePlate)) {
            return false;
        }
        
        this.carOwners.put(licensePlate, owner);
        return true;
    }
    
    public boolean inRegistry(LicensePlate licensePlate) {
        if (this.carOwners.containsKey(licensePlate)) {
            return true;
        }
        return false;
    }
    
    public String get(LicensePlate licensePlate) {
        return this.carOwners.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (this.inRegistry(licensePlate)) {
            this.carOwners.remove(licensePlate);
            return true;
        }
        
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate licensePlate : this.carOwners.keySet()) {
            System.out.println(licensePlate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> printedOwners = new ArrayList<>();
        
        for (String owner : this.carOwners.values()) {
            if (!(printedOwners.contains(owner))) {
                System.out.println(owner);
                printedOwners.add(owner);
            }
        }
    }
}
