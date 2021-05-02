package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class TextStatisticsApplication extends Application{

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox horizontal = new HBox();
        horizontal.setSpacing(10);
        
        layout.setCenter(new TextArea());
        layout.setBottom(horizontal);
        
        horizontal.getChildren().add(new Label("Letters: 0"));
        horizontal.getChildren().add(new Label("Words: 0"));
        horizontal.getChildren().add(new Label("The longest word is:"));
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
