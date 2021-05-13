/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;
import java.util.List;
import javafx.scene.layout.Pane;
import java.util.stream.Collectors;
/**
 *
 * @author Frankie
 */
public abstract class Character {
    private Polygon polygon;
    private Point2D movement;
    private boolean alive;
    
    public Character(Polygon polygon, int x, int y) {
        this.polygon = polygon;
        this.polygon.setTranslateX(x);
        this.polygon.setTranslateY(y);
        
        this.movement = new Point2D(0,0);
        this.alive = true;
    }
    
    public Polygon getCharacter() {
        return this.polygon;
    }
    
    public Point2D getMovement() {
        return this.movement;
    }
    
    public boolean isAlive() {
        return alive;
    }
    
    public void setAlive(boolean bool) {
        this.alive = bool;
    }
    
    public void setMovement(Point2D movement) {
        this.movement = movement;
    }
    
    public void turnLeft() {
        this.polygon.setRotate(polygon.getRotate()-5);
    }
    
    public void turnRight() {
        this.polygon.setRotate(polygon.getRotate()+5);
    }
    
    public void move() {
        double currentXPosition = this.polygon.getTranslateX();
        double currentYPosition = this.polygon.getTranslateY();
        
        this.polygon.setTranslateX(currentXPosition + this.movement.getX());
        this.polygon.setTranslateY(currentYPosition + this.movement.getY());
        
        if (currentXPosition > AsteroidsApplication.WIDTH) {
            this.polygon.setTranslateX(currentXPosition - AsteroidsApplication.WIDTH);
        } else if (currentXPosition < 0) {
            this.polygon.setTranslateX(currentXPosition + AsteroidsApplication.WIDTH);
        }
        if (currentYPosition > AsteroidsApplication.HEIGHT) {
            this.polygon.setTranslateY(currentYPosition - AsteroidsApplication.HEIGHT);
        } else if (currentYPosition < 0) {
            this.polygon.setTranslateY(currentYPosition + AsteroidsApplication.HEIGHT);
        }
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
