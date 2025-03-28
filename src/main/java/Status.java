public class Status {
    private String Name;

    private String Color;

    private int StatusType;
    /*
     * 1 - Physical Attack
     * 2 - Physical Defense
     * 3 - Magical Attack
     * 4 - Magical Defense
     * 5 - Speed
     * 6 - Health
     */

    private int Duration;
    /*
     * -1 - Permanent
     * >0 - Duration in turns
     */

    private boolean IsPermanent;

    private double Modifier;

    private int ModifierType;
    /*
     * 1 - Addition/Subtraction
     * 2 - Multiplication/Division
     * 3 - Set
     * 4 - Random
     * 5 - Percent
     */

    private int Level;
    // Multiplier for the status effect

    private int MaxLevel;
    // 1 - Does not stack
    // 2+ - Stacks

    private boolean LevelupEveryTurn;
    // true = level up every turn
    // false = level up when status is applied again

    private boolean DynamicDescription;
    // true = description changes with level
    // false = description does not change with level

    private String Description;

    public Status(String Name, String Color, int StatusType, int Duration, double Modifier, int ModifierType, int Level, int MaxLevel, boolean LevelupEveryTurn, String Description) {
        this.Name = Name;
        this.Color = Color;
        this.StatusType = StatusType;
        this.Duration = Duration;
        this.Modifier = Modifier;
        this.ModifierType = ModifierType;
        this.Level = Level;
        this.MaxLevel = MaxLevel;
        this.LevelupEveryTurn = LevelupEveryTurn;
        this.Description = Description;

        if (Description == null || Description.isEmpty()) {
            this.DynamicDescription = true;
        } else {
            this.DynamicDescription = false;
        }

        if (Duration == -1) {
            IsPermanent = true;
        } else {
            IsPermanent = false;
        }

        // Validation
        if (Name == null || Name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (Color == null || Color.isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty.");
        }
        if (StatusType < 1 || StatusType > 6) {
            throw new IllegalArgumentException("StatusType must be between 1 and 6.");
        }
        if (Duration < -1 || Duration == 0) {
            throw new IllegalArgumentException("Duration must be -1 or greater than 0.");
        }
        if (ModifierType < 1 || ModifierType > 5) {
            throw new IllegalArgumentException("ModifierType must be between 1 and 5.");
        }
        if (Level < 1) {
            throw new IllegalArgumentException("Level must be 1 or greater.");
        }
        if (MaxLevel < 1) {
            throw new IllegalArgumentException("MaxLevel must be 1 or greater.");
        }
        if (MaxLevel < Level) {
            throw new IllegalArgumentException("MaxLevel must be greater than or equal to Level.");
        }
    }

    public Status(String Name, int StatusType, int Duration, double Modifier, int ModifierType, int Level, int MaxLevel, boolean LevelupEveryTurn, String Description) {
        this(Name, "white", StatusType, Duration, Modifier, ModifierType, Level, MaxLevel, LevelupEveryTurn, Description);
    }

    public Status(String Name, String Color, int StatusType, int Duration, double Modifier, int ModifierType, int Level, int MaxLevel, boolean LevelupEveryTurn) {
        this(Name, Color, StatusType, Duration, Modifier, ModifierType, Level, MaxLevel, LevelupEveryTurn, null);
    }

    public Status(String Name, int StatusType, int Duration, double Modifier, int ModifierType, int Level, int MaxLevel, boolean LevelupEveryTurn) {
        this(Name, "white", StatusType, Duration, Modifier, ModifierType, Level, MaxLevel, LevelupEveryTurn, null);
    }

    public Status(String Name, int StatusType, int Duration, double Modifier, int ModifierType, int Level, int MaxLevel, String Description) {
        this(Name, "white", StatusType, Duration, Modifier, ModifierType, Level, MaxLevel, false, Description);
    }

    public Status(String Name, String Color, int StatusType, int Duration, double Modifier, int ModifierType, String Description) {
        this(Name, Color, StatusType, Duration, Modifier, ModifierType, 1, 1, false, Description);
    }

    public Status(String Name, int StatusType, int Duration, double Modifier, int ModifierType, String Description) {
        this(Name, "white", StatusType, Duration, Modifier, ModifierType, 1, 1, false, Description);
    }

    public Status(String Name, String Color, int StatusType, int Duration, double Modifier, int ModifierType, int Level, int MaxLevel) {
        this(Name, Color, StatusType, Duration, Modifier, ModifierType, Level, MaxLevel, false, null);
    }

    public Status(String Name, int StatusType, int Duration, double Modifier, int ModifierType, int Level, int MaxLevel) {
        this(Name, "white", StatusType, Duration, Modifier, ModifierType, Level, MaxLevel, false, null);
    }

    public Status(String Name, String Color, int StatusType, int Duration, double Modifier, int ModifierType) {
        this(Name, Color, StatusType, Duration, Modifier, ModifierType, 1, 1, false, null);
    }

    public Status(String Name, int StatusType, int Duration, double Modifier, int ModifierType) {
        this(Name, "white", StatusType, Duration, Modifier, ModifierType, 1, 1, false, null);
    }

    public String getName() {
        return Name;
    }

    public String getColor() {
        return Color;
    }

    public int getStatusType() {
        return StatusType;
    }

    public int getDuration() {
        return Duration;
    }

    public double getModifier() {
        return Modifier;
    }

    public int getModifierType() {
        return ModifierType;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getMaxLevel() {
        return MaxLevel;
    }

    public String getDescription() {
        return Description;
    }

    public void statusTick(Unit unit) {
        if (StatusType == 6) {
            if (Modifier > 0) {
                switch (ModifierType) {
                    case 1:
                        unit.healHealth((int) (Modifier * Level), true);
                        break;
                    case 2:
                        unit.healHealth((int) (unit.getHealth() * Modifier * Level), true);
                        break;
                    case 3:
                        unit.setHealth((int) Modifier);
                        break;
                    case 4:
                        unit.healHealth((int) (Math.random() * Modifier * Level), true);
                        break;
                    case 5:
                        unit.healHealth((int) (unit.getMaxHealth() * (Modifier / 100) * Level), true);
                        break;
                }
            } else {
                switch (ModifierType) {
                    case 1:
                        unit.takeDamage((int) (Modifier * Level * -1), true);
                        break;
                    case 2:
                        unit.takeDamage((int) (unit.getHealth() * Modifier * Level * -1), true);
                        break;
                    case 3:
                        unit.setHealth((int) Modifier);
                        break;
                    case 4:
                        unit.takeDamage((int) (Math.random() * Modifier * Level * -1), true);
                        break;
                    case 5:
                        unit.takeDamage((int) (unit.getMaxHealth() * (Modifier / 100) * Level * -1), true);
                        break;
                }
            }
        }

        if (LevelupEveryTurn && Level < MaxLevel && !isExpired()) {
            Level++;
            System.out.println("The effects of " + Format.formatText(Name, Color) + " are getting stronger!");
        }

        if (Duration > 0 && !IsPermanent) {
            Duration--;
        }
    }

    public boolean isExpired() {
        return (Duration <= 0 && !IsPermanent);
    }

    public String toString() {
        String output = "";

        output += Format.formatText(Name, Color);

        if (MaxLevel > 1) {
            output += Format.formatText(" " + Utils.toRoman(Level), Color);
        }

        if (IsPermanent) {
            output += " (Permanent)\n";
        } else {
            if (Duration == 1) {
                output += " (1 turn)\n";
            } else {
                output += " (" + Duration + " turns)\n";
            }
        }

        if (!DynamicDescription) {
            output += Format.formatText(" - " + Description, Color);
        } else {
            output += Format.formatText(" - ", Color);

            switch (StatusType) {
                case 1:
                    switch (ModifierType) {
                        case 1:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical attack by " + ((int) (Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases physical attack by " + ((int) (Modifier * Level * -1)), Color);
                            }
                            break;
                        case 2:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical attack by " + ((int) (Modifier * Level)) + " times", Color);
                            } else {
                                output += Format.formatText("Decreases physical attack by " + ((int) (Modifier * Level * -1)) + " times", Color);
                            }
                            break;
                        case 3:
                            output += Format.formatText("Sets physical attack to " + ((int) (Modifier * Level)), Color);
                            break;
                        case 4:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical attack by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases physical attack by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level * -1)), Color);
                            }
                            break;
                        case 5:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical attack by " + ((int) (Modifier * Level)) + "%", Color);
                            } else {
                                output += Format.formatText("Decreases physical attack by " + ((int) (Modifier * Level * -1)) + "%", Color);
                            }
                            break;
                        default:
                            output += Format.formatText("Error creating dynamic description", Color);
                            break;
                    }
                    break;
                case 2:
                    switch (ModifierType) {
                        case 1:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical defense by " + ((int) (Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases physical defense by " + ((int) (Modifier * Level * -1)), Color);
                            }
                            break;
                        case 2:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical defense by " + ((int) (Modifier * Level)) + " times", Color);
                            } else {
                                output += Format.formatText("Decreases physical defense by " + ((int) (Modifier * Level * -1)) + " times", Color);
                            }
                            break;
                        case 3:
                            output += Format.formatText("Sets physical defense to " + ((int) (Modifier * Level)), Color);
                            break;
                        case 4:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical defense by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases physical defense by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level * -1)), Color);
                            }
                            break;
                        case 5:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases physical defense by " + ((int) (Modifier * Level)) + "%", Color);
                            } else {
                                output += Format.formatText("Decreases physical defense by " + ((int) (Modifier * Level * -1)) + "%", Color);
                            }
                            break;
                        default:
                            output += Format.formatText("Error creating dynamic description", Color);
                            break;
                    }
                    break;
                case 3:
                    switch (ModifierType) {
                        case 1:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical attack by " + ((int) (Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases magical attack by " + ((int) (Modifier * Level * -1)), Color);
                            }
                            break;
                        case 2:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical attack by " + ((int) (Modifier * Level)) + " times", Color);
                            } else {
                                output += Format.formatText("Decreases magical attack by " + ((int) (Modifier * Level * -1)) + " times", Color);
                            }
                            break;
                        case 3:
                            output += Format.formatText("Sets magical attack to " + ((int) (Modifier * Level)), Color);
                            break;
                        case 4:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical attack by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases magical attack by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level * -1)), Color);
                            }
                            break;
                        case 5:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical attack by " + ((int) (Modifier * Level)) + "%", Color);
                            } else {
                                output += Format.formatText("Decreases magical attack by " + ((int) (Modifier * Level * -1)) + "%", Color);
                            }
                            break;
                        default:
                            output += Format.formatText("Error creating dynamic description", Color);
                            break;
                    }
                    break;
                case 4:
                    switch (ModifierType) {
                        case 1:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical defense by " + ((int) (Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases magical defense by " + ((int) (Modifier * Level * -1)), Color);
                            }
                            break;
                        case 2:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical defense by " + ((int) (Modifier * Level)) + " times", Color);
                            } else {
                                output += Format.formatText("Decreases magical defense by " + ((int) (Modifier * Level * -1)) + " times", Color);
                            }
                            break;
                        case 3:
                            output += Format.formatText("Sets magical defense to " + ((int) (Modifier * Level)), Color);
                            break;
                        case 4:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical defense by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases magical defense by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level * -1)), Color);
                            }
                            break;
                        case 5:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases magical defense by " + ((int) (Modifier * Level)) + "%", Color);
                            } else {
                                output += Format.formatText("Decreases magical defense by " + ((int) (Modifier * Level * -1)) + "%", Color);
                            }
                            break;
                        default:
                            output += Format.formatText("Error creating dynamic description", Color);
                            break;
                    }
                    break;
                case 5:
                    switch (ModifierType) {
                        case 1:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases speed by " + ((int) (Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases speed by " + ((int) (Modifier * Level * -1)), Color);
                            }
                            break;
                        case 2:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases speed by " + ((int) (Modifier * Level)) + " times", Color);
                            } else {
                                output += Format.formatText("Decreases speed by " + ((int) (Modifier * Level * -1)) + " times", Color);
                            }
                            break;
                        case 3:
                            output += Format.formatText("Sets speed to " + ((int) (Modifier * Level)), Color);
                            break;
                        case 4:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases speed by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level)), Color);
                            } else {
                                output += Format.formatText("Decreases speed by a random amount between 0 - " + ((int) (Math.random() * Modifier * Level * -1)), Color);
                            }
                            break;
                        case 5:
                            if (Modifier > 0) {
                                output += Format.formatText("Increases speed by " + ((int) (Modifier * Level)) + "%", Color);
                            } else {
                                output += Format.formatText("Decreases speed by " + ((int) (Modifier * Level * -1)) + "%", Color);
                            }
                            break;
                        default:
                            output += Format.formatText("Error creating dynamic description", Color);
                            break;
                    }
                    break;
                case 6:
                    switch (ModifierType) {
                        case 1:
                            if (Modifier > 0) {
                                output += Format.formatText("Heals " + ((int) (Modifier * Level)) + " health every turn", Color);
                            } else {
                                output += Format.formatText("Damages " + ((int) (Modifier * Level * -1)) + " health every turn", Color);
                            }
                            break;
                        case 2:
                            if (Modifier > 0) {
                                output += Format.formatText("Heals by " + ((int) (Modifier * Level * 100)) + "% of current health every turn", Color);
                            } else {
                                output += Format.formatText("Damages by " + ((int) (Modifier * Level * -100)) + "% of current health every turn", Color);
                            }
                            break;
                        case 3:
                            output += Format.formatText("Sets health to " + ((int) (Modifier)) + " every turn", Color);
                            break;
                        case 4:
                            if (Modifier > 0) {
                                output += Format.formatText("Heals a random amount of health between 0 - " + ((int) (Math.random() * Modifier * Level)) + "  every turn", Color);
                            } else {
                                output += Format.formatText("Damages a random amount of health between 0 - " + ((int) (Math.random() * Modifier * Level * -1)) + " every turn", Color);
                            }
                            break;
                        case 5:
                            if (Modifier > 0) {
                                output += Format.formatText("Heals " + ((int) (Modifier * Level)) + "% of max health every turn", Color);
                            } else {
                                output += Format.formatText("Deals " + ((int) (Modifier * Level  * -1)) + "% of max health as damage every turn", Color);
                            }
                            break;
                        default:
                            output += Format.formatText("Error creating dynamic description", Color);
                            break;
                    }
                    break;
                default:
                    output += Format.formatText("Error creating dynamic description", Color);
                    break;
            }
        }

        return output;
    }
}