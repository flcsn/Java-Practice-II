/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class OneItemBox extends Box { 
    
    public OneItemBox() {
        super();
    }
    
    @Override
    public void add(Item item) {
        if (this.getItems().isEmpty()) {
            this.getItems().add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        return this.getItems().contains(item);
    }
    
}
