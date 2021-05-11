/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;
import java.util.Random;

/**
 *
 * @author Frankie
 */
public class Asteroid extends Character {
    private double rotationalMovement;
    
    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);
        
        Random random = new Random();
        
        this.getCharacter().setRotate(random.nextInt(360));
        for (int i = 0; i < 1 + random.nextInt(10); i++) {
            accelerate();
        }
        
        this.rotationalMovement = 0.5 - random.nextDouble();
    }
    
    @Override
    public void move() {
        super.move();
        this.getCharacter().setRotate(this.getCharacter().getRotate() + rotationalMovement);
    }
}
