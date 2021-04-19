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

public class StorageFacility {
    private HashMap<String,ArrayList<String>> storages;
            
    public StorageFacility() {
        this.storages = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        this.storages.putIfAbsent(unit, new ArrayList<>());
        this.storages.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return this.storages.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        ArrayList<String> storedItems = this.storages.get(storageUnit);
        
        for (String storedItem : storedItems) {
            if (item.equals(storedItem)) {
                storedItems.remove(storedItem);
                break;
            }
        }
        
        if (storedItems.isEmpty()) {
            this.storages.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> unitsWithItems = new ArrayList<>();
        
        for (String unit : this.storages.keySet()) {
            if (!(this.storages.get(unit) == null)) {
                unitsWithItems.add(unit);
            }
        }
        
        return unitsWithItems;
    }
    
    
    
}
