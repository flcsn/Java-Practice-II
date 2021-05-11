/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.util.Random;
import javafx.scene.shape.Polygon;
import java.lang.Math;

/**
 *
 * @author Frankie
 */
public class PolygonFactory {
    private Random random;
    
    public PolygonFactory() {
        this.random = new Random();
    }
    
    public Polygon createPolygon() {
        double size = 10.0;
        
        double c1 = Math.cos(2 * Math.PI / 5) * size + random.nextInt(5) - 2;
        double c2 = Math.cos(Math.PI / 5) * size + random.nextInt(5) - 2;
        double s1 = Math.sin(2 * Math.PI / 5) * size + random.nextInt(5) - 2;
        double s2 = Math.sin(4 * Math.PI / 5) * size + random.nextInt(5) - 2;
        
        Polygon polygon = new Polygon(
                size, 0.0,
                c1, s1,
                -c2, s2,
                -c2, -s2,
                c1, -s1
        );
        
        return polygon;
    }
}
