package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class SavingsCalculatorApplication extends Application {
    
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis(0, 27500, 2500);
        
        LineChart lineChart = new LineChart(xAxis, yAxis);
        
        layout.setCenter(lineChart);
        
        BorderPane savingsPane = new BorderPane();
        Label savingsText = new Label("Monthly savings");
        Slider savingsSlider = new Slider(25, 250, 25);
        Label savingsRate = new Label(String.valueOf(savingsSlider.getValue()));
        savingsSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            savingsRate.setText(newValue.toString().format("%.2f", newValue));
        });
        
        
        savingsPane.setLeft(savingsText);
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsRate);
        
        BorderPane interestPane = new BorderPane();
        Label interestText = new Label("Yearly interest");
        Slider interestSlider = new Slider(0, 10, .01);
        Label interestRate = new Label(String.valueOf(interestSlider.getValue()));
        interestSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            interestRate.setText(newValue.toString().format("%.2f", newValue));
        });
        
        interestPane.setLeft(interestText);
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestRate);

        
        VBox vBox = new VBox();
        layout.setTop(vBox);
        vBox.getChildren().addAll(savingsPane, interestPane);
        
        XYChart.Series data = new XYChart.Series();
        
        data.getData().add(new XYChart.Data("2500", "1"));
        data.getData().add(new XYChart.Data("5000", "2"));
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
