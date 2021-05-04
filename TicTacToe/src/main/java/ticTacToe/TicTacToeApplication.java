package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {
    
    private Player player;
    private boolean gameOver;
    
    public void init() throws Exception {
        this.gameOver = false;
    }
    
    public void start(Stage window) {
        Player X = new Player(Symbol.X);
        Player O = new Player(Symbol.O);
        
        this.player = X;
        
        BorderPane layout = new BorderPane();
        GridPane grid = new GridPane();
        HBox info = new HBox();
        
        Label label = new Label("Turn: " + this.player);
        
        info.getChildren().addAll(label);
        
        Button[][] buttons = new Button[3][3];
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                Button button = new Button("");
                button.setFont(Font.font("Monospaced", 40));
                button.setOnAction((event) -> {
                    if (!button.getText().equals("") || this.gameOver == true) {
                        return;
                    }
                    button.setText(this.player.toString());
                    if (checkForWinner(buttons) == true) {
                        label.setText("The end!");
                        this.gameOver = true;
                        return;
                    }
                    if (this.player == X) {
                        this.player = O;
                    } else {
                        this.player = X;
                    }
                    label.setText("Turn: " + this.player);
                });
                buttons[j][i] = button;
                grid.add(button, j, i);
            }
        }
        
        layout.setPadding(new Insets(10, 10, 10, 10));
        info.setSpacing(10);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        layout.setTop(label);
        layout.setCenter(grid);
        
        Scene view = new Scene(layout, 300, 300);
        
        window.setTitle("Tic-Tac-Toe!");
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
    
    public static boolean checkForWinner(Button[][] buttons) {
        if (checkForHorizontalLine(buttons) || checkForVerticalLine(buttons) || checkForDiagonalLine(buttons)) {
            return true;
        }
        return false;
    }
    
    public static boolean checkForHorizontalLine(Button[][] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[0][i].getText().equals("X") && buttons[1][i].getText().equals("X") && buttons[2][i].getText().equals("X")
                    || buttons[0][i].getText().equals("O") && buttons[1][i].getText().equals("O") && buttons[2][i].getText().equals("O")) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkForVerticalLine(Button[][] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i][0].getText().equals("X") && buttons[i][1].getText().equals("X") && buttons[i][2].getText().equals("X")
                    || buttons[i][0].getText().equals("O") && buttons[i][1].getText().equals("O") && buttons[i][2].getText().equals("O")) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkForDiagonalLine(Button[][] buttons) {
        if (buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X")
                || buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][2].getText().equals("O")
                || buttons[0][2].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][0].getText().equals("X")
                || buttons[0][2].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][0].getText().equals("O")) {
            return true;
        }
        return false;
    }
}
