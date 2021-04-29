package FlightControl;

import java.util.Scanner;
import FlightControl.domain.*;
import FlightControl.logic.*;
import FlightControl.ui.*;


public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        FlightControl flightControl = new FlightControl();
        AirportAssetControlUI AAC = new AirportAssetControlUI(scanner, flightControl);
        FlightControlUI FC = new FlightControlUI(scanner, flightControl);
        
        AAC.start();
        FC.start();
    }
}
