package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class GreeterApplication extends Application {
    
    public void start(Stage window) {
        Label instructions = new Label("Enter your name and start.");
        TextField input = new TextField();
        Button startButton = new Button("Start");
        
        VBox login = new VBox();
        login.getChildren().addAll(instructions, input, startButton);
        
        login.setPrefSize(300, 180);
        login.setAlignment(Pos.CENTER);
        login.setSpacing(10);
        login.setPadding(new Insets(20, 20, 20, 20));
        
        VBox welcome = new VBox();
        Label welcomeMessage = new Label("Welcome!");
        welcome.getChildren().add(welcomeMessage);
        
        welcome.setPrefSize(300, 180);
        welcome.setAlignment(Pos.CENTER);
        welcome.setSpacing(10);
        welcome.setPadding(new Insets(20, 20, 20, 20));
        
        Scene loginView = new Scene(login);
        Scene welcomeView = new Scene(welcome);
        
        startButton.setOnAction((event) -> {
            welcomeMessage.setText("Welcome " + input.getText() + "!");
            window.setScene(welcomeView);
        });
        
        window.setScene(loginView);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
