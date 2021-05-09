package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class SmileyApplication extends Application {

    public void start(Stage window) {
        Canvas canvas = new Canvas(640, 480);
        GraphicsContext painter = canvas.getGraphicsContext2D();
        
        BorderPane layout = new BorderPane();
        
        layout.setCenter(canvas);
        
        painter.setFill(Color.BLACK);
        painter.fillOval(160, 96, 40, 40);
        painter.fillOval(480, 96, 40, 40);
        painter.strokeArc(320.0, 240.0, 90.0, 90.0, 0.0, -180.0, ArcType.OPEN);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
