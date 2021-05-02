package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class JokeApplication extends Application{

    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        
        Button showJoke = new Button("Joke");
        Button showAnswer = new Button("Answer");
        Button showExplanation = new Button("Explanation");
        
        menu.getChildren().addAll(showJoke, showAnswer, showExplanation);
        
        menu.setSpacing(10);
        menu.setPrefSize(300,180);
        
        layout.setTop(menu);
        
        Label joke = new Label("What do you call a bear with no teeth?");
        Label answer = new Label("A gummy bear.");
        Label explanation = new Label("Get it? GUMmy bear.");
        
        layout.setCenter(joke);
        
        showJoke.setOnAction((event) -> layout.setCenter(joke));
        showAnswer.setOnAction((event) -> layout.setCenter(answer));
        showExplanation.setOnAction((event) -> layout.setCenter(explanation));
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
