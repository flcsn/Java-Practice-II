
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        List<Integer> numbers = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            numbers.add(Integer.valueOf(input));
        }
        
        System.out.println("Print the average of negative numbers of the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        
        if (choice.equals("n")) {
            double average = numbers.stream()
                    .mapToInt(n -> n)
                    .filter(n -> n < 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        } else if (choice.equals("p")) {
            double average = numbers.stream()
                    .mapToInt(n -> n)
                    .filter(n -> n > 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        }

    }
}
