/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Frankie
 */
public class PracticeView {
    private Dictionary dictionary;
    private String wordToTranslate;
    
    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.wordToTranslate = this.dictionary.getRandomWord();
    }
    
    public Parent getView() {
        GridPane layout = new GridPane();
        
        Label instructions = new Label("Translate the word '" + wordToTranslate + "'");
        TextField answerField = new TextField();
        Button checkAnswer = new Button("Check");
        Label feedback = new Label("");
        
        layout.add(instructions, 0, 0);
        layout.add(answerField, 0, 1);
        layout.add(checkAnswer, 0, 2);
        layout.add(feedback, 0, 3);
        
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        checkAnswer.setOnAction((event) -> {
            String answer = answerField.getText();
            if (!dictionary.translate(wordToTranslate).equals(answer)) {
                feedback.setText("Incorrect! The correct translation is " + dictionary.translate(answer) + "!");
                return;
            }
            feedback.setText("Correct!");
            this.wordToTranslate = dictionary.getRandomWord();
            answerField.clear();
            instructions.setText("Translate the word '" + wordToTranslate + "'");
        });
        
        return layout;
    }
}
