
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .map(parts -> new LiteracyRate(parts[0], parts[1], parts[2], parts[3], Integer.valueOf(parts[4]), Double.valueOf(parts[5])))
                    .sorted((r1, r2) -> {
                        return r1.compareTo(r2);
                    }).forEach(rate -> System.out.println(rate));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }        
    }
    
    
}
