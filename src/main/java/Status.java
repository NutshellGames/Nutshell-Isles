public class Status {
    private String name;

    private String color;

    private int statusType;
    /*
     * 1 - Physical Attack
     * 2 - Physical Defense
     * 3 - Magical Attack
     * 4 - Magical Defense
     * 5 - Speed
     * 6 - Health
     */

    private int duration;

    private double modifier;

    private int modifierType;
    /*
     * 1 - Addition/Subtraction
     * 2 - Multiplication/Division
     * 3 - Set
     * 4 - Random
     * 5 - Percent
     */

    private int level;

    private int maxLevel;

    private String description;

    public Status() {}

    public Status(String name, String color, int statusType, int duration, double modifier, int modifierType, int level, int maxLevel, String description) {
        this.name = name;
        this.color = color;
        this.statusType = statusType;
        this.duration = duration;
        this.modifier = modifier;
        this.modifierType = modifierType;
        this.level = level;
        this.maxLevel = maxLevel;
        this.description = description;
    }

    public Status(String name, int statusType, int duration, double modifier, int modifierType, int level, int maxLevel, String description) {
        this.name = name;
        this.color = "white";
        this.statusType = statusType;
        this.duration = duration;
        this.modifier = modifier;
        this.modifierType = modifierType;
        this.level = level;
        this.maxLevel = maxLevel;
        this.description = description;
    }

    public Status(String name, String color, int statusType, int duration, double modifier, int modifierType, String description) {
        this.name = name;
        this.color = color;
        this.statusType = statusType;
        this.duration = duration;
        this.modifier = modifier;
        this.modifierType = modifierType;
        this.level = 1;
        this.maxLevel = 1;
        this.description = description;
    }

    public Status(String name, int statusType, int duration, double modifier, int modifierType, String description) {
        this.name = name;
        this.color = "white";
        this.statusType = statusType;
        this.duration = duration;
        this.modifier = modifier;
        this.modifierType = modifierType;
        this.level = 1;
        this.maxLevel = 1;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getStatusType() {
        return statusType;
    }

    public int getDuration() {
        return duration;
    }

    public double getModifier() {
        return modifier;
    }

    public int getModifierType() {
        return modifierType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public String getDescription() {
        return description;
    }
}