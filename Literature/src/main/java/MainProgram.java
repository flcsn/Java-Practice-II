
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        
        while (true) {
            System.out.println("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.equals("")) {break;}
            System.out.println("Input the age recommendation");
            int age = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(name, age));
        }
        
        System.out.println(books.stream().count() + " books in total.");
        System.out.println("");
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getName);
        
        books.stream()
                .sorted(comparator)
                .forEach(book -> System.out.println(book));
    }

}
