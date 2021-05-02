package notifier;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NotifierApplication extends Application {
    
    public void start(Stage window) {
        TextField text = new TextField();
        Button button = new Button("Update");
        Label label = new Label();
        
        button.setOnAction((event) -> label.setText(text.getText()));
        
        VBox v = new VBox();
        v.getChildren().addAll(text, button, label);
        
        Scene view = new Scene(v);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
