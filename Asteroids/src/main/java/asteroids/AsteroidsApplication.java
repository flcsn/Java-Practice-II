package asteroids;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class AsteroidsApplication extends Application {
    
    public void start(Stage window) throws Exception {
        Pane layout = new Pane();
        layout.setPrefSize(600, 400);
        
        Ship ship = new Ship(300, 200);
        List<Asteroid> asteroids = new ArrayList<>();
        
        layout.getChildren().add(ship.getCharacter());
        
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            asteroids.add(new Asteroid(random.nextInt(100), random.nextInt(100)));
        }
        
        asteroids.stream()
                .forEach(asteroid -> layout.getChildren().add(asteroid.getCharacter()));
        
        Scene view = new Scene(layout);
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        view.setOnKeyPressed(key -> {
            pressedKeys.put(key.getCode(), true);
        });
        
        view.setOnKeyReleased(key -> {
            pressedKeys.put(key.getCode(), false);
        });
        
        new AnimationTimer() {
            
            @Override
            public void handle(long now) {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
            }
        }.start();
        
        window.setTitle("Asteroids!");
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 3;
    }

}
