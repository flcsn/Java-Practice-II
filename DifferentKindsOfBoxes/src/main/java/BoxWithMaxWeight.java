/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class BoxWithMaxWeight extends Box {
    private int max;
    private int current;
    
    public BoxWithMaxWeight(int max) {
        this.max = max;
        this.current = 0;
    }
    
    public int remainingSpace() {
        return this.max - this.current;
    }
    
    @Override
    public void add(Item item) {
        if (item.getWeight() > this.remainingSpace()) {
            return;
        }
        
        this.getItems().add(item);
        this.current += item.getWeight();
    }
    
    @Override
    public boolean isInBox(Item item) {
        if (this.getItems().contains(item)) {
            return true;
        }
        return false;
    }
    
    
}
