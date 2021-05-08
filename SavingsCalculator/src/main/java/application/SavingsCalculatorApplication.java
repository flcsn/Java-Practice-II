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

public class SavingsCalculatorApplication extends Application {
    
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");
        lineChart.setAnimated(false);
        
        layout.setCenter(lineChart);
        
        BorderPane savingsPane = new BorderPane();
        Label savingsText = new Label("Monthly savings");
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);
        Label savingsRate = new Label(String.valueOf(savingsSlider.getValue()));
        
        savingsPane.setLeft(savingsText);
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsRate);
        
        BorderPane interestPane = new BorderPane();
        Label interestText = new Label("Yearly interest rate");
        Slider interestSlider = new Slider(0, 10, 0.0);
        interestSlider.setShowTickLabels(true);
        interestSlider.setShowTickMarks(true);
        Label interestRate = new Label(String.valueOf(interestSlider.getValue()));
        
        interestPane.setLeft(interestText);
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestRate);

        VBox vBox = new VBox();
        layout.setTop(vBox);
        vBox.getChildren().addAll(savingsPane, interestPane);
        
        XYChart.Series savingsData = new XYChart.Series();
        savingsData.setName("Simple savings");
        
        XYChart.Series compoundSavingsData = new XYChart.Series();
        compoundSavingsData.setName("Compound savings");
        
        for (int i = 0; i <= xAxis.getUpperBound(); i++) {
            savingsData.getData().add(new XYChart.Data(i, savingsSlider.getValue()*i*12));
            compoundSavingsData.getData().add(new XYChart.Data(i, savingsSlider.getValue()*i*12));
        }
        
        savingsSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            savingsRate.setText(String.valueOf(newValue).format("%.2f", newValue));
            calculateSavings(savingsData, xAxis.getUpperBound(), newValue.doubleValue(), 0.0);
            calculateSavings(compoundSavingsData, xAxis.getUpperBound(), newValue.doubleValue(), interestSlider.getValue());
        });
        
        interestSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            interestRate.setText(newValue.toString().format("%.2f", newValue));
            calculateSavings(compoundSavingsData, xAxis.getUpperBound(), savingsSlider.getValue(), newValue.doubleValue());
        });
        
        lineChart.getData().add(savingsData);
        lineChart.getData().add(compoundSavingsData);
        
        Scene view = new Scene(layout);
        
        window.setTitle("Savings calculator!");
        window.setScene(view);
        window.show();
    }
    
    public static void calculateSavings(XYChart.Series series, double upperBoundOfX, double yearlySavings, double interestRate) {
        series.getData().clear();
        
        Double principal = 0.0;
        
        series.getData().add(new XYChart.Data(0, principal));
        for (int i = 1; i <= upperBoundOfX; i++) {
            principal += yearlySavings * 12;
            principal += principal * interestRate/100;
            series.getData().add(new XYChart.Data(i, principal));
        }
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
