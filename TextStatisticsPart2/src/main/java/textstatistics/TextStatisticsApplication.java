package textstatistics;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import java.util.Arrays;

public class TextStatisticsApplication extends Application{

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox horizontal = new HBox();
        horizontal.setSpacing(10);
        
        TextArea text = new TextArea();

        layout.setCenter(text);
        layout.setBottom(horizontal);
        
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longest = new Label("The longest word is: ");
        
        horizontal.getChildren().addAll(letters, words, longest);
        
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int wordCount = parts.length;
            String longestWord = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            letters.setText("Letters: " + String.valueOf(characters));
            words.setText("Words: " + String.valueOf(wordCount));
            longest.setText("The longest word is: " +longestWord);
        });
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
