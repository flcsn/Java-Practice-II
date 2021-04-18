
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            System.out.println(cube(Integer.valueOf(input)));
         }
    }
    
    public static int cube(int number) {
        return number * number * number;
    }
}
