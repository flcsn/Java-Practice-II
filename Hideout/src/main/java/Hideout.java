/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class Hideout<T> {
    private T object;
    
    public void putIntoHideout(T toHide) {
        this.object = toHide;
    }
    
    public T takeFromHideout() {
        T objectTaken = this.object;
        this.object = null;
        return objectTaken;
    }
    
    public boolean isInHideout() {
        if (this.object == null) {
            return false;
        } return true;
    }
}
