public class Items {
    private String Name;
    private int ItemType;
    /*
        1 - Held (Passive)
        2 - Single Use (Cannot be held)
        3 - Universal (Passive, cannot be held)
    */
    
    private int Effect; 
    /* 
        1 - Physical Attack
        2 - Magical Attack
        3 - Physical Defence
        4 - Magical Defence
        5 - Health
        6 - Max Health
        7 - Deal Damage
        8 - Exp
        9 - Level
    */
    
    private int BoostType;
    /*
        1 - Addition/Subtraction
        2 - Multiplication/Division
    */
    
    private double Modifier;
    //  Number the effect is modified by
    
    private int Targets;
    /*
        1 - Self
        2 - Ally (or Self)
        3 - All Allies
        4 - Enemy
        5 - All Enemies
        6 - All
        7 - Random
    */

    private int Rarity;
    /*
        1 - Nut
        2 - Nut+
        3 - Nutrutious
        4 - Nutty
        5 - Nuttastic
        6 - Mythnutical
        7 - NUT LORD
    */
    
    private Unit Holder;
    
    private String Description;
    
    public Items(String Name, int ItemType, int Effect, int BoostType, double Modifier, int Targets, int Rarity, Unit Holder, String Description) {
        this.Name = Name;
        this.ItemType = ItemType;
        this.Effect = Effect;
        this.BoostType = BoostType;
        this.Modifier = Modifier;
        this.Targets = Targets;
        this.Rarity = Rarity;
        this.Holder = Holder;
        this.Description = Description;
    }
    
    public Items(String Name, int ItemType, int Effect, int BoostType, double Modifier, int Targets, int Rarity, String Description) {
        this.Name = Name;
        this.ItemType = ItemType;
        this.Effect = Effect;
        this.BoostType = BoostType;
        this.Modifier = Modifier;
        this.Targets = Targets;
        this.Rarity = Rarity;
        this.Holder = null;
        this.Description = Description;
    }
    
    public String getName(boolean includeRarity) {
        if (includeRarity) {
            switch (this.Rarity) {
                case 1:
                    return Format.formatText(this.Name, "gray");
                case 2:
                    return Format.formatText(this.Name, "green");
                case 3:
                    return Format.formatText(this.Name, "cyan");
                case 4:
                    return Format.formatText(this.Name, "brown");
                case 5:
                    return Format.formatText(this.Name, "orange");
                case 6:
                    return Format.formatText(this.Name, "magenta");
                case 7:
                    return Format.formatText(this.Name, "red");
                default:
                    return this.Name;
            }
        } else {
            return this.Name;
        }
    }

    public String getName() {
        return this.getName(false);
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public int getType() {
        return this.ItemType;
    }
    
    public int getEffect() {
        return this.Effect;
    }
    
    public double getModifier() {
        return this.Modifier;
    }
    
    public int getTargets() {
        return this.Targets;
    }

    public int getBoostType() {
        return this.BoostType;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public Unit getHolder() {
        return this.Holder;
    }
    
    public void setHolder(Unit Holder) {
        this.Holder = Holder;
    }
    
    public void equip(Unit unit) {
        if (unit.getItem() != null) {
            Items prevItem = unit.getItem();
            prevItem.unequip();
        }
        
        this.Holder = unit;
        unit.setItem(this);
    }
    
    public void unequip() {
        Items oldItem = this.Holder.getItem();
        
        Unit holder = oldItem.getHolder();
        
        holder.setItem(null);
        oldItem.setHolder(null);
        
        Data.addItem(oldItem);
    }
    
    public String toString() {
        String finalstring = "";
        
        finalstring += this.Name;

        switch (this.Rarity) {
            case 1:
                finalstring += " (" + Format.formatText("Nut", "gray") + ")\n";
                break;
            case 2:
                finalstring += " (" + Format.formatText("Nut+", "green") + ")\n";
                break;
            case 3:
                finalstring += " (" + Format.formatText("Nutrutious", "cyan") + ")\n";
                break;
            case 4:
                finalstring += " (" + Format.formatText("Nutty", "brown") + ")\n";
                break;
            case 5:
                finalstring += " (" + Format.formatText("Nuttastic", "orange") + ")\n";
                break;
            case 6:
                finalstring += " (" + Format.formatText("Mythnutical", "magenta") + ")\n";
                break;
            case 7:
                finalstring += " (" + Format.formatText("NUT LORD", "red") + ")\n";
                break;
            default:
                break;
        }

        finalstring += " - " + this.Description + "\n";

        return finalstring;
    }
}