package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

// END SOLUTION
public class VocabularyPracticeApplication extends Application{

    private Dictionary dictionary;
    
    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary(); 
   }
    
    @Override
    public void start(Stage window) throws Exception{
        
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        Button goToInputView = new Button("Enter new words");
        Button goToPracticeView = new Button("Practice");
        
        menu.getChildren().addAll(goToInputView, goToPracticeView);
        layout.setTop(menu);
        
        goToInputView.setOnAction((event) -> {
            layout.setCenter(inputView.getView());
        });
        
        goToPracticeView.setOnAction((event) -> {
            layout.setCenter(practiceView.getView());
        });
        
        layout.setCenter(inputView.getView());
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
    public static void main(String[] args){
        launch(VocabularyPracticeApplication.class);
    }
}
