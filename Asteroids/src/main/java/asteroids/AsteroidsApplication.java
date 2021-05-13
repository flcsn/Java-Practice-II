package asteroids;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.scene.text.Text;
import java.util.concurrent.atomic.AtomicInteger;

public class AsteroidsApplication extends Application {
    public static int WIDTH = 600;
    public static int HEIGHT = 400;
    
    public void start(Stage window) throws Exception {
        Pane layout = new Pane();
        layout.setPrefSize(WIDTH, HEIGHT);
        
        Text pointsText = new Text(10, 20, "Points: 0");
        AtomicInteger points = new AtomicInteger();
        layout.getChildren().add(pointsText);
        
        Ship ship = new Ship(WIDTH/2, HEIGHT/2);
        List<Asteroid> asteroids = new ArrayList<>();
        List<Projectile> projectiles = new ArrayList<>();
        
        layout.getChildren().add(ship.getCharacter());
        
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            asteroids.add(new Asteroid(random.nextInt(WIDTH/3), random.nextInt(HEIGHT)));
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
                if (Math.random() < 0.005) {
                    Random random = new Random();
                    Asteroid asteroid = new Asteroid(random.nextInt(WIDTH/3), random.nextInt(HEIGHT));
                    
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        layout.getChildren().add(asteroid.getCharacter());
                    }
                }
                
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
                    
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    
                    layout.getChildren().add(projectile.getCharacter());
                }
                
                ship.move();
                
                asteroids.forEach(asteroid -> asteroid.move());
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
                
                projectiles.forEach(projectile -> projectile.move());
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                            pointsText.setText("Points: " + points.addAndGet(1000));
                        }
                    });
                });
                removeDeadCharacters(projectiles, layout);
                removeDeadCharacters(asteroids, layout);
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
        return 4;
    }
    
    public static void removeDeadCharacters(List<? extends Character> listOfCharacters, Pane layout) {
        List<Character> charactersToRemove = listOfCharacters.stream()
                .filter(character -> !character.isAlive())
                .collect(Collectors.toList());
        
        listOfCharacters.removeAll(charactersToRemove);
        layout.getChildren().removeAll(charactersToRemove.stream()
                .map(character -> character.getCharacter())
                .collect(Collectors.toList()));
    }
}
