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
    
    private Unit Holder;
    
    private String Description;
    
    public Items(String Name, int ItemType, int Effect, int BoostType, double Modifier, int Targets, Unit Holder, String Description) {
        this.Name = Name;
        this.ItemType = ItemType;
        this.Effect = Effect;
        this.BoostType = BoostType;
        this.Modifier = Modifier;
        this.Targets = Targets;
        this.Holder = Holder;
        this.Description = Description;
    }
    
    public Items(String Name, int ItemType, int Effect, int BoostType, double Modifier, int Targets, String Description) {
        this.Name = Name;
        this.ItemType = ItemType;
        this.Effect = Effect;
        this.BoostType = BoostType;
        this.Modifier = Modifier;
        this.Targets = Targets;
        this.Holder = null;
        this.Description = Description;
    }
    
    public String getName() {
        return this.Name;
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
        
        return finalstring;
    }
}