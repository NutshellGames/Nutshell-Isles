// Java Util Imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;

// Java File Imports
import java.io.File; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

// Gson Imports
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Data {
    private static ArrayList<Unit> Party = new ArrayList<Unit>();
    private static ArrayList<Unit> InnMembers = new ArrayList<Unit>();
    private static ArrayList<Items> Items = new ArrayList<Items>();
    
    static ArrayList<Unit> getParty() {
        return Party;
    }

    static void addToParty(Unit unit) {
        Party.add(unit);
    }
    
    static void removeFromParty(Unit unit) {
        Party.remove(unit);
    }

    static ArrayList<Unit> getInnMembers() {
        return InnMembers;
    }

    static void addToInn(Unit unit) {
        InnMembers.add(unit);
    }

    static void removeFromInn(Unit unit) {
        InnMembers.remove(unit);
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
                return new Unit("Lil Timmy", 100, 100, 1, createPremadeRace(8), createPremadeRole(6), 10, 10, 10, 10, 5, new ArrayList<Skill>(Arrays.asList(createPremadeSkill(0), createPremadeSkill(1), createPremadeSkill(2))));
            default:
                return null;
        }
    }
    
    static Skill createPremadeSkill(int id) {
        switch(id) {
            case 0:
                return new Skill("Test Attack", 1, true, 20, 100, 10, 1);
            case 1:
                return new Skill("Test Heal", 4, false, 20, 100, 10, 3);
            case 2:
                return new Skill("Test Splash Attack", 1, false, 15, 100, 7, 2);
            default:
                return null;
        }
    }
    
    static Status createPremadeStatus(int id) {
        switch (id) {
            case 0:
                return new Status("Scent of Nuts", "brown", 6, 3, 10, 1);
            case 1:
                return new Status("Burning Nuts", "red", 6, (int) (Math.random() * 2 + 3), -5, 5);
            case 2:
                return new Status("Freezing Nuts", "cyan", 5, (int) (Math.random() * 2 + 1), -50, 5);
            case 3:
                return new Status("Poisoned Nuts", "ivy", 6, (int) (Math.random() * 3), -10, 5);
            case 4:
                return new Status("Toxic Nuts", "purple", 6, (int) (Math.random() * 2 + 2), -10, 5, 1, 3, true);
            case 5:
                return new Status("Shocking Nuts", "yellow", 5, 1, -20, 5);
            default:
                return null;
        }
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

    static Races createPremadeRace(int id) {
        switch(id) {
            case 0:
                return new Races("Human", 0);
            case 1:
                return new Races("Elf", 1);
            case 2:
                return new Races("Dwarf", 2);
            case 3:
                return new Races("Orc", 3);
            case 4:
                return new Races("Goblin", 4);
            case 5:
                return new Races("Undead", 5);
            case 6:
                return new Races("Halfling", 6);
            case 7:
                return new Races("Gnome", 7);
            case 8:
                return new Races("Troll", 8);
            default:
                return null;
        }
    }

    static Role createPremadeRole(int id) {
        switch(id) {
            case 0:
                return new Role("Drifter", 0);
            case 1:
                return new Role("Swordsman", 1);
            case 2:
                return new Role("Warrior", 2);
            case 3:
                return new Role("Knight", 3);
            case 4:
                return new Role("Holy Knight", 4);
            case 5:
                return new Role("Barbarian", 5);
            case 6:
                return new Role("Savage", 6);
            case 7:
                return new Role("Mage", 7);
            case 8:
                return new Role("Wizard", 8);
            case 9:
                return new Role("Sorcerer", 9);
            case 10:
                return new Role("Sorcerer Supreme", 10);
            case 11:
                return new Role("Dark Wizard", 11);
            case 12:
                return new Role("Necromancer", 12);
            case 13:
                return new Role("Bowman", 13);
            case 14:
                return new Role("Archer", 14);
            case 15:
                return new Role("Ranger", 15);
            case 16:
                return new Role("Sniper", 16);
            case 17:
                return new Role("Rogue", 17);
            case 18:
                return new Role("Assassin", 18);
            case 19:
                return new Role("Healer", 19);
            case 20:
                return new Role("Cleric", 20);
            case 21:
                return new Role("Bishop", 21);
            case 22:
                return new Role("Archbishop", 22);
            case 23:
                return new Role("Alchemist", 23);
            case 24:
                return new Role("Potions Master", 24);
            case 25:
                return new Role("Nut of All Trades", 25);
            case 26:
                return new Role("Peanut Butter", 26);
            case 27:
                return new Role("Nutella Champion", 27);
            default:
                return null;
        }
    }

    static File getOldestSaveFile() {
        File saveDir = new File("saves");
        File[] saveFiles = saveDir.listFiles((dir, name) -> name.endsWith(".json"));
        
        if (saveFiles == null || saveFiles.length == 0) {
            return null; // No save files found
        }
        
        // Sort files by last modified date
        Arrays.sort(saveFiles, (f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
        
        return saveFiles[0]; // Return the oldest file
    }

    static void saveData(String filename) {
        try {
            File savefile = new File("saves/" + filename + ".json");

            // Create the directory if it doesn't exist
            if (!savefile.exists()) {
                savefile.createNewFile();
            } else {
                System.out.println("File by the name " + filename + " already exists! Would you like to Overwrite it? (Y/N)");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                scanner.close();

                if (input.equalsIgnoreCase("N")) {
                    System.out.println("File not overwritten.");
                    return;
                } else if (!input.equalsIgnoreCase("Y")) {
                    System.out.println("Invalid input. File not overwritten.");
                    return;
                }
            }

            File saveDir = new File("saves");
            File[] saveFiles = saveDir.listFiles((dir, name) -> name.endsWith(".json"));

            if (saveFiles != null && saveFiles.length > 10) {
                // If there are 10 or more save files, delete the oldest one
                File oldestFile = getOldestSaveFile();
                if (oldestFile != null) {
                    oldestFile.delete();
                }
            }
            

            FileWriter dataWriter = new FileWriter("saves/" + filename + ".json");

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Create a wrapper object to hold all data
            DataWrapper dataWrapper = new DataWrapper();

            // Add System Timestamp
            dataWrapper.Date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());

            // Add Game Version
            dataWrapper.Version = "0.1.1";

            // Serialize each list
            dataWrapper.Party = Party;
            dataWrapper.InnMembers = InnMembers;
            dataWrapper.Items = Items;

            // Convert the data to JSON
            String jsonData = gson.toJson(dataWrapper);

            // Write JSON to file
            dataWriter.write(jsonData);
            dataWriter.close();

            System.out.println("Successfully saved data!");
        } catch (IOException e) {
            System.out.println("An error has occurred while saving data.");
            e.printStackTrace();
        }
    }

    static void loadData(String filename) {
        try {
            // Read the JSON file
            FileReader dataReader = new FileReader("saves/" + filename + ".json");
            StringBuilder data = new StringBuilder();

            int i;
            while ((i = dataReader.read()) != -1) {
                data.append((char) i);
            }

            dataReader.close();

            Gson gson = new Gson();

            // Deserialize JSON into the DataWrapper class
            DataWrapper dataWrapper = gson.fromJson(data.toString(), DataWrapper.class);

            // Access the fields
            String date = dataWrapper.Date;
            String version = dataWrapper.Version;

            System.out.println("Date: " + date);
            System.out.println("Version: " + version);
            System.out.println("Loading data...");

            // Assign the lists
            Party = dataWrapper.Party;
            InnMembers = dataWrapper.InnMembers;
            Items = dataWrapper.Items;

            // Tell the user that the data has been loaded
            System.out.println("Successfully loaded data!");
        } catch (IOException e) {
            System.out.println("An error has occurred while loading data.");
            e.printStackTrace();
        }
    }
}