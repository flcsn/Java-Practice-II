
public class Main {

    public static void main(String[] args) {
        // test your classes here
        Box box = new Box(10.0); 
        Packable cd = new CD("Pink Floyd", "Dark side of the moon", 1972);
        box.add(cd);    
        System.out.println(box);
    }

}
