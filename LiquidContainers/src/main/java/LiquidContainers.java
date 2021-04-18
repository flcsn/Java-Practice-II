
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] splittedInput = input.split(" ");
            
            String command = splittedInput[0];
            int amount = Integer.valueOf(splittedInput[1]);
            
            if (amount < 0) {
                amount = 0;
            }
            
            if (command.equals("add")) {
                first = first + amount;
                if (first > 100) {
                    first = 100;
                }
                
            } else if (command.equals("move")) {
                if (amount > first) {
                    amount = first;
                    first = 0;
                    
                } else {
                    first = first - amount;
                }
                
                second = second + amount;
                
                if (second > 100) { 
                    second = 100;
                }
                
            } else if (command.equals("remove")) {
                second = second - amount;
                
                if (second < 0) {
                    second = 0;
                }
            }

        }
    }

}
