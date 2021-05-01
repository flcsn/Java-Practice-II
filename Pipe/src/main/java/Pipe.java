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

public class Pipe<T> {
    private ArrayList<T> values;
    
     public Pipe() {
         this.values = new ArrayList<>();
     }
     
     public void putIntoPipe(T value) {
         this.values.add(value);
     }
     
     public T takeFromPipe() {
         if (values.isEmpty()) {
             return null;
         }
         T valueToRemove = values.get(0);
         values.remove(0);
         return valueToRemove;
     }
     
     public boolean isInPipe() {
         return !values.isEmpty();
     }
   
}
