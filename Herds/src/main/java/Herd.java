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

public class Herd implements Movable {
    private ArrayList<Movable> members;
    
    public Herd() {
        this.members = new ArrayList<>();
    }
    
    public String toString() {
        String string = "";
        
        for (Movable member : members) {
            string += member + "\n";
        }
        
        return string;
    }
    
    public void addToHerd(Movable movable) {
        this.members.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable member : members) {
            member.move(dx, dy);
        }
    }
}
