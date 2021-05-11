/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;
/**
 *
 * @author Frankie
 */
public abstract class Character {
    private Polygon polygon;
    private Point2D movement;
    
    public Character(Polygon polygon, int x, int y) {
        this.polygon = polygon;
        this.polygon.setTranslateX(x);
        this.polygon.setTranslateY(y);
        
        this.movement = new Point2D(0,0);
    }
    
    public Polygon getCharacter() {
        return this.polygon;
    }
    
    public void turnLeft() {
        this.polygon.setRotate(polygon.getRotate()-5);
    }
    
    public void turnRight() {
        this.polygon.setRotate(polygon.getRotate()+5);
    }
    
    public void move() {
        this.polygon.setTranslateX(this.polygon.getTranslateX() + this.movement.getX());
        this.polygon.setTranslateY(this.polygon.getTranslateY() + this.movement.getY());
    }
    
    public void accelerate() {
        double changeX = 0.05*Math.cos(Math.toRadians(this.polygon.getRotate()));
        double changeY = 0.05*Math.sin(Math.toRadians(this.polygon.getRotate()));
        
        this.movement = this.movement.add(changeX, changeY);
    }
    
    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.polygon, other.getCharacter());
        return collisionArea.getBoundsInLocal().getHeight() != -1;
    }
    
    
}
