package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application{
    
    @Override
    public void start(Stage window) {
        Button buttonComponent = new Button("Button");
        Label labelComponent = new Label("Label");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(labelComponent);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
