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

public class Box implements Packable{
    private ArrayList<Packable> items;
    private double max;
    
    public Box(double max) {
        this.items = new ArrayList<>();
        this.max = max;
    }
    
    public void add(Packable item) {        
        if (item.weight() <= this.spaceLeft()) {
            this.items.add(item);
        }
    }
    
    public double weight() {
        double weight = 0.0;
         
       for (Packable item : this.items) {
            weight += item.weight();
        }
        
        return weight;
    }
    
    public double spaceLeft() {
        return this.max - this.weight();
    }
    
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}
