import java.util.ArrayList;
import java.util.Arrays;
import java.io.File; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Data {
    private static ArrayList<Unit> Party = new ArrayList<Unit>();
    private static ArrayList<Unit> InnMembers = new ArrayList<Unit>();
    private static ArrayList<Items> Items = new ArrayList<Items>();

    private static File savedata = new File("data.txt");
    
    static void addToParty(Unit unit) {
        Party.add(unit);
    }
    
    static void addToInn(Unit unit) {
        InnMembers.add(unit);
    }
    
    static ArrayList<Items> getItems() {
        return Items;
    }
    
    static void addItem(Items item) {
        Items.add(item);
    }
    
    static void removeItem(Items item) {
        Items.remove(item);
    }
    
    static Unit createPremadeUnit(int id) {
        switch(id) {
            case 0:
                return new Unit("Test", 100, 100, 1, 10, 10, 10, 10, 5, new ArrayList<Skill>(Arrays.asList(new Skill())));
            default:
                return null;
        }
    }
    
    static Skill createPremadeSkill(int id) {
        return null;
    }
    
    static Status createPremadeStatus(int id) {
        return null;
    }
    
    static Items createPremadeItem(int id) {
        switch(id) {
            case 0:
                return new Items("Small Exp Boost", 1, 8, 2, 1.5, 1, 5, "Increases Holder's Exp gained by 50%");
            case 1:
                return new Items("Medium Exp Boost", 1, 8, 2, 2, 1, 6, "Increases Holder's Exp gained by 100%");
            case 2:
                return new Items("Large Exp Boost", 1, 8, 2, 3, 1, 7, "Increases Holder's Exp gained by 200%");
            default:
                return null;
        }
    }
    
    static String convertUnitToString() {
        return "This does not work yet. Sorry!";
    }
    
    static void saveData() {
        try {
            FileWriter dataWriter = new FileWriter("data.txt");

            dataWriter.write(Cypher.encrypt("Data saved at: " + java.time.LocalDateTime.now() + "\n"));
            dataWriter.close();
            System.out.println("Successfully saved data!");
        } catch (IOException e) {
            System.out.println("An error has occurred while saving data.");
        }
    }

    static void loadData() {
        try {
            FileReader dataReader = new FileReader("data.txt");
            String data = "";

            int i = 0;
            while ((i = dataReader.read()) != -1) {
                data += (char) i;
            }

            System.out.println(Cypher.decrypt(data));
            dataReader.close();
            System.out.println("Successfully loaded data!");
        } catch (IOException e) {
            System.out.println("An error has occurred while loading data.");
        }
        
    }
}