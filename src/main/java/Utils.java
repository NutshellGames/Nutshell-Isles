import java.util.Scanner;

// This class contains helpful methods that are widely used but don't belong in the other classes
public class Utils {
    private static Scanner input = new Scanner(System.in);
    
    // This method takes an input but ignores it, used to slow down gameplay
    public static void blankInput(boolean clear) {
        String blank = input.nextLine();

        if (clear) {
            System.out.println(blank);
            clearTerminal();
        }
    }

    public static void blankInput() {blankInput(false);}
    
    // This method clears the terminal by printing many blank lines
    public static void clearTerminal() {
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }

    // Turns an int into roman numerals
    public static String toRoman(int number) {
        String roman = "";
        while (number >= 1000) {
            roman += "M";
            number -= 1000;
        }
        while (number >= 900) {
            roman += "CM";
            number -= 900;
        }
        while (number >= 500) {
            roman += "D";
            number -= 500;
        }
        while (number >= 400) {
            roman += "CD";
            number -= 400;
        }
        while (number >= 100) {
            roman += "C";
            number -= 100;
        }
        while (number >= 90) {
            roman += "XC";
            number -= 90;
        }
        while (number >= 50) {
            roman += "L";
            number -= 50;
        }
        while (number >= 40) {
            roman += "XL";
            number -= 40;
        }
        while (number >= 10) {
            roman += "X";
            number -= 10;
        }
        while (number >= 9) {
            roman += "IX";
            number -= 9;
        }
        while (number >= 5) {
            roman += "V";
            number -= 5;
        }
        while (number >= 4) {
            roman += "IV";
            number -= 4;
        }
        while (number >= 1) {
            roman += "I";
            number -= 1;
        }
        return roman;
    }

    /** 
       Pauses the program for a specified number of seconds.
       Takes a double to allow for fractional seconds
       (e.g. 0.5 for half a second)
       @param seconds - the number of seconds to pause the program
       @throws InterruptedException if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.
    **/
    static void pause(double seconds) {
        try {
            double time = seconds * 1000;
            Thread.sleep((long) time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the opposite of the given multiplier 
     * (e.g. 2.0 -> 0.5, 0.5 -> 2.0)
     * @param mult - the multiplier to flip
     * @return double - the flipped multiplier
     **/
    static double multiplierFlip(double mult) {
        if (mult == 0) {
            return 0;
        }

        return 1 / mult;
    }
}

/**
 * A simple tuple class to hold two related values together
 * Example usage: Tuple<String, Integer> myTuple = new Tuple<>("Hello", 5);
 * @param <t1> - the type of the first value
 * @param <t2> - the type of the second value
 **/
class Tuple<t1, t2> {
    t1 first;
    t2 second;

    public Tuple(t1 first, t2 second) {
        this.first = first;
        this.second = second;
    }
}