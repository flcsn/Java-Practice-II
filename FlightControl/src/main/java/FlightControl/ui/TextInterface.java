/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

import java.util.Scanner;
import FlightControl.logic.FlightControl;

/**
 *
 * @author Frankie
 */
public class TextInterface {
    private Scanner scanner;
    private FlightControl flightControl;
    
    public TextInterface(Scanner scanner, FlightControl flightControl) {
        this.scanner = scanner;
        this.flightControl = flightControl;
    }
    
    public void start() {
        while (true) {
            printAACInstructions();
            String input = scanner.nextLine();
            
            if (input.equals("x")) {
                break;
            }
            
            int intput = Integer.valueOf(input);
            
            if (intput == 1) {
                addAirplane();
            } else if (intput == 2) {
                addFlight();
            }
        }
    }
    
    public void printAACInstructions() {
        System.out.println("Choose an action:");
        System.out.println("[1] Add an airplane");
        System.out.println("[2] Add a flight");
        System.out.println("[x] Exit Airport Asset Control");
        System.out.print("> ");
    }
    
    public void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(scanner.nextLine());
        
        this.flightControl.addAirplane(id, capacity);
    }
    
    public void addFlight() {
        System.out.print("Give the airplane id: ");
        String id = getAirplaneId();
        System.out.print("Give the departure airport id: ");
        String placeOfDeparture = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String placeOfArrival = scanner.nextLine();
        
        this.flightControl.addFlight(id, placeOfDeparture, placeOfArrival);
    }
    
    public String getAirplaneId() {
        while (true) {
            String id = scanner.nextLine();
            if (!(airplaneExists(id))) {
                return id;
            }
            System.out.println("Airplane not found.");
        }
    }
    
    public boolean airplaneExists(String id) {
        return this.flightControl.checkIfAirplaneExists(id);
    }
}
