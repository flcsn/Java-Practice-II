package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class PartiesApplication extends Application{

    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Year");
        yAxis.setLabel("(%)");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        Map<String, Map<Integer, Double>> totalData = new HashMap<>();
        
        // Read data from file and save into Maps for reading
        try (Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            String headers = scanner.nextLine();
            String[] splittedHeaders = headers.split("\t");
            
            // Map each party's data year by year and save into a Map
            while(scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] splittedRow = row.split("\t");
                
                Map<Integer, Double> yearByYearData =  new HashMap<>();
                for (int i = 1; i < splittedRow.length; i++) {
                    if (splittedRow[i].equals("-")) {
                        continue;
                    }
                    yearByYearData.putIfAbsent(Integer.valueOf(splittedHeaders[i]), Double.parseDouble(splittedRow[i]));
                }
                // Saves the party's data into the bigger Map data structure
                totalData.put(splittedRow[0], yearByYearData);
            }
        } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        }
        // Create plottable data from Maps created earlier
        totalData.keySet().stream()
                .forEach(party -> {
                    XYChart.Series partyData = new XYChart.Series();
                    partyData.setName(party);
                    
                    totalData.get(party).entrySet().forEach(pair -> {
                        partyData.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                    });
                    
                    lineChart.getData().add(partyData);
                });
        
        Scene view = new Scene(lineChart);
        
        window.setScene(view);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
