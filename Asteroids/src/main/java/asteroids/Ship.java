/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;
import javafx.geometry.Point2D;
/**
 *
 * @author Frankie
 */
public class Ship {
    private Polygon player;
    private Point2D movement;
    
    public Ship(int x, int y) {
        this.player = new Polygon(
                0, -5,
                0, 5,
                15, 0
        );
        this.player.setTranslateX(x);
        this.player.setTranslateY(y);
        
        this.movement = new Point2D(0,0);
    }
    
    public Polygon getCharacter() {
        return player;
    }
    
    public void turnLeft() {
        this.player.setRotate(player.getRotate()-5);
    }
    
    public void turnRight() {
        this.player.setRotate(player.getRotate()+5);
    }
    
    public void move() {
        this.player.setTranslateX(this.player.getTranslateX() + this.movement.getX());
        this.player.setTranslateY(this.player.getTranslateY() + this.movement.getY());
    }
    
    public void accelerate() {
        double changeX = 0.05*Math.cos(Math.toRadians(this.player.getRotate()));
        double changeY = 0.05*Math.sin(Math.toRadians(this.player.getRotate()));
        
        this.movement = this.movement.add(changeX, changeY);
    }
    
    
}
