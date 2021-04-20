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

public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        
        double maxValue = history.get(0);
        
        for (double entry : history) {
            if (maxValue < entry) {
                maxValue = entry;
            }
        }
        
        return maxValue;
    }
    
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        
        double minValue = history.get(0);
        
        for (double entry : history) {
            if (minValue > entry) {
                minValue = entry;
            }
        }
        
        return minValue;
    }
    
    public int count() {
        return this.history.size();
    }
    
    public double average() {
        double sum = 0;
        
        for (double entry : history) {
            sum += entry;
        }
        
        return sum / this.count();
    }
    
    public void clear() {
        this.history.clear();
    }
    
    public String toString() {
        return this.history.toString();
    }
}
