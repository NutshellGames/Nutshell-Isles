import java.util.Scanner;

// This class contains helpful methods that are widely used but don't belong in the other classes
public class Utils {
    private static Scanner input = new Scanner(System.in);
    
    // This method takes an input but ignores it, used to slow down gameplay
    public static void blankInput() {
        String blank = input.nextLine();
    }
    
    // This method clears the terminal by printing many blank lines
    public static void clearTerminal() {
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }
}