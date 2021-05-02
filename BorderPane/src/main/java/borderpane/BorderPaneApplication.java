package borderpane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class BorderPaneApplication extends Application{

    @Override
    public void start(Stage window) {
        Label north = new Label("NORTH");
        Label east = new Label("EAST");
        Label south = new Label("SOUTH");
        
        BorderPane layout = new BorderPane();
        layout.setTop(north);
        layout.setRight(east);
        layout.setBottom(south);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
        
    }

}