
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            int number = Integer.valueOf(input);
            
            if (number > 0) {
                positives.add(number);
            } else if (number < 0) {
                negatives.add(number);
            }
        }
        
        System.out.println("Print the average of negative numbers of the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        
        if (choice.equals("n")) {
            double average = negatives.stream()
                    .mapToInt(n -> n)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        } else if (choice.equals("p")) {
            double average = positives.stream()
                    .mapToInt(n -> n)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        }

    }
}
