public class Format {
    private static final String RESET = "\u001B[0m";

    // Text Colors
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    // Bright Text Colors
    private static final String GRAY = "\u001B[90m";
    private static final String BRIGHT_RED = "\u001B[91m";
    private static final String BRIGHT_GREEN = "\u001B[92m";
    private static final String BRIGHT_YELLOW = "\u001B[93m";
    private static final String BRIGHT_BLUE = "\u001B[94m";
    private static final String BRIGHT_PURPLE = "\u001B[95m";
    private static final String BRIGHT_CYAN = "\u001B[96m";
    private static final String BRIGHT_WHITE = "\u001B[97m";

    // Custom Text Colors
    private static final String PINK = "\u001B[95m";
    private static final String ORANGE = "\u001B[38;5;208m";
    private static final String BROWN = "\u001B[38;5;130m";
    private static final String TAN = "\u001B[38;5;180m";
    private static final String LIME = "\u001B[38;5;118m";
    private static final String TEAL = "\u001B[38;5;30m";
    private static final String SKY = "\u001B[38;5;39m";
    private static final String LAVENDER = "\u001B[38;5;183m";
    private static final String MINT = "\u001B[38;5;121m";
    private static final String TURQUOISE = "\u001B[38;5;80m";
    private static final String MAROON = "\u001B[38;5;52m";
    private static final String LIGHT_GRAY = "\u001B[38;5;250m";
    private static final String DARK_GRAY = "\u001B[38;5;235m";
    private static final String DARK_BLUE = "\u001B[38;5;17m";
    private static final String DARK_GREEN = "\u001B[38;5;22m";
    private static final String DARK_RED = "\u001B[38;5;124m";
    private static final String DARK_PURPLE = "\u001B[38;5;54m";
    private static final String DARK_CYAN = "\u001B[38;5;37m";
    private static final String DARK_YELLOW = "\u001B[38;5;130m";
    private static final String DARK_ORANGE = "\u001B[38;5;208m";
    private static final String DARK_PINK = "\u001B[38;5;201m";
    private static final String IVY = "\u001B[38;5;28m";

    // Text Formatting
    private static final String UNDERLINE = "\u001B[4m";

    // Special Characters
    public static final String STAR = "\u2606";

    // formatTextMethods
    static String formatText(String text, String color, boolean underlined) {
        String finaltext = "";

        if (underlined) {
            finaltext += UNDERLINE;
        }

        switch (color.toLowerCase()) {
            case ("black"):
                finaltext += BLACK;
                break;
            case ("red"):
                finaltext += RED;
                break;
            case ("green"):
                finaltext += GREEN;
                break;
            case ("yellow"):
                finaltext += YELLOW;
                break;
            case ("blue"):
                finaltext += BLUE;
                break;
            case ("purple"):
                finaltext += PURPLE;
                break;
            case ("cyan"):
                finaltext += CYAN;
                break;
            case ("white"):
                finaltext += WHITE;
                break;
            case ("gray"):
                finaltext += GRAY;
                break;
            case ("bright red"):
                finaltext += BRIGHT_RED;
                break;
            case ("bright green"):
                finaltext += BRIGHT_GREEN;
                break;
            case ("bright yellow"):
                finaltext += BRIGHT_YELLOW;
                break;
            case ("bright blue"):
                finaltext += BRIGHT_BLUE;
                break;
            case ("bright purple"):
                finaltext += BRIGHT_PURPLE;
                break;
            case ("bright cyan"):
                finaltext += BRIGHT_CYAN;
                break;
            case ("bright white"):
                finaltext += BRIGHT_WHITE;
                break;
            case ("brown"):
                finaltext += BROWN;
                break;
            case ("orange"):
                finaltext += ORANGE;
                break;
            case ("pink"):
                finaltext += PINK;
                break;
            case ("lime"):
                finaltext += LIME;
                break;
            case ("teal"):
                finaltext += TEAL;
                break;
            case ("sky"):
                finaltext += SKY;
                break;
            case ("lavender"):
                finaltext += LAVENDER;
                break;
            case ("mint"):
                finaltext += MINT;
                break;
            case ("turquoise"):
                finaltext += TURQUOISE;
                break;
            case ("maroon"):
                finaltext += MAROON;
                break;
            case ("light gray"):
                finaltext += LIGHT_GRAY;
                break;
            case ("dark gray"):
                finaltext += DARK_GRAY;
                break;
            case ("dark blue"):
                finaltext += DARK_BLUE;
                break;
            case ("dark green"):
                finaltext += DARK_GREEN;
                break;
            case ("dark red"):
                finaltext += DARK_RED;
                break;
            case ("dark purple"):
                finaltext += DARK_PURPLE;
                break;
            case ("dark cyan"):
                finaltext += DARK_CYAN;
                break;
            case ("dark yellow"):
                finaltext += DARK_YELLOW;
                break;
            case ("dark orange"):
                finaltext += DARK_ORANGE;
                break;
            case ("dark pink"):
                finaltext += DARK_PINK;
                break;
            case ("ivy"):
                finaltext += IVY;
                break;
            default:
                break;
        }

        finaltext += text + RESET;

        return finaltext;
    }

    static String formatText(String text, String color) {return formatText(text, color, false);}

    static String formatText(String text, boolean underlined) {return formatText(text, "white", underlined);}

    // typeSpecialCharacterMethods
    static String typeSpecialCharacter(String character, String color, boolean underlined, int count, boolean space) {
        String finaltext = "";

        switch (character.toLowerCase()) {
            case "star":
                for (int i = 0; i < count; i++) {
                    finaltext += formatText(STAR, color, underlined);
                    if (space) {
                        finaltext += " ";
                    }
                }
                break;
            default:
                break;
        }

        return finaltext;
    }

    static String typeSpecialCharacter(String character, String color, int count, boolean space) {return typeSpecialCharacter(character, color, false, count, space);}

    static String typeSpecialCharacter(String character, String color, boolean underlined) {return typeSpecialCharacter(character, color, underlined, 1, false);}

    static String typeSpecialCharacter(String character, String color, boolean underlined, int count) {return typeSpecialCharacter(character, color, underlined, count, false);}

    static String typeSpecialCharacter(String character, String color) {return typeSpecialCharacter(character, color, false, 1, false);}

    static String typeSpecialCharacter(String character, boolean underlined, int count, boolean space) {return typeSpecialCharacter(character, "white", underlined, count, space);}

    static String typeSpecialCharacter(String character) {return typeSpecialCharacter(character, "white", false, 1, false);}

    static String typeSpecialCharacter(String character, boolean underlined, int count) {return typeSpecialCharacter(character, "white", underlined, count, false);}

    static String typeSpecialCharacter(String character, boolean underlined) {return typeSpecialCharacter(character, "white", underlined, 1, false);}

    static String typeSpecialCharacter(String character, int count, boolean space) {return typeSpecialCharacter(character, "white", false, count, space);}

    static String typeSpecialCharacter(String character, int count) {return typeSpecialCharacter(character, "white", false, count, false);}

    static String typeSpecialCharacter(String character, String color, int count) {return typeSpecialCharacter(character, color, false, count, false);}

    // Other Methods
    static void printLogo(String color) {
        System.out.println(formatText(" /$$   /$$             /$$              /$$                 /$$ /$$       /$$$$$$           /$$                    ", color));
        System.out.println(formatText("| $$$ | $$            | $$             | $$                | $$| $$      |_  $$_/          | $$                    ", color));
        System.out.println(formatText("| $$$$| $$ /$$   /$$ /$$$$$$   /$$$$$$$| $$$$$$$   /$$$$$$ | $$| $$        | $$    /$$$$$$$| $$  /$$$$$$   /$$$$$$$", color));
        System.out.println(formatText("| $$ $$ $$| $$  | $$|_  $$_/  /$$_____/| $$__  $$ /$$__  $$| $$| $$        | $$   /$$_____/| $$ /$$__  $$ /$$_____/ ", color));
        System.out.println(formatText("| $$  $$$$| $$  | $$  | $$   |  $$$$$$ | $$  \\ $$| $$$$$$$$| $$| $$        | $$  |  $$$$$$ | $$| $$$$$$$$|  $$$$$$ ", color));
        System.out.println(formatText("| $$\\  $$$| $$  | $$  | $$ /$$\\____  $$| $$  | $$| $$_____/| $$| $$        | $$   \\____  $$| $$| $$_____/ \\____  $$", color));
        System.out.println(formatText("| $$ \\  $$|  $$$$$$/  |  $$$$//$$$$$$$/| $$  | $$|  $$$$$$$| $$| $$       /$$$$$$ /$$$$$$$/| $$|  $$$$$$$ /$$$$$$$/", color));
        System.out.println(formatText("|__/  \\__/ \\______/    \\___/ |_______/ |__/  |__/ \\_______/|__/|__/      |______/|_______/ |__/ \\_______/|_______/ ", color));
    }

    static void printLogo() {
        printLogo("white");
	}
}