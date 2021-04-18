
import java.util.Scanner;
import java.util.ArrayList;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            
            if (input == 0) {
                break;
            }
            
            if (input > 0) {
                numbers.add(input);
            }
        }
        
        if (numbers.isEmpty()) {
            System.out.println("Cannot calculate the average");
            
        } else {
            System.out.println(calculateAverage(numbers));
        }
        
    }
    
    public static double calculateAverage(ArrayList<Integer> numbers) {
        int sum = 0;
        
        for (int number : numbers) {
            sum += number;
        }
        
        return (double) sum / numbers.size();
        
    }
}
