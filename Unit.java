import java.util.ArrayList;

public class Unit {
    private int Health;
    private int MaxHealth;
    private int Level;
    private int Exp;
    private int MaxExp;
    private String Name;
    private int PhysicalDamage;
    private int MagicDamage;
    private int PhysicalDefence;
    private int MagicDefence;
    private int Speed;
    private ArrayList<Status> Statuses;
    private ArrayList<Skill> Skills;
    private Items Item;
    
    // Constructors
    public Unit(String Name, int Health, int MaxHealth, int Level, int PhysicalDamage, int MagicDamage, int PhysicalDefence, int MagicDefence, int Speed, ArrayList<Skill> Skills, Items Item) {
        this.Name = Name;
        this.Health = Health;
        this.MaxHealth = MaxHealth;
        this.Level = Level;
        this.Exp = 0;
        this.MaxExp = 100 * (int)(Math.pow(Level, 0.9));
        this.PhysicalDamage = PhysicalDamage;
        this.MagicDamage = MagicDamage;
        this.PhysicalDefence = PhysicalDefence;
        this.MagicDefence = MagicDefence;
        this.Speed = Speed;
        this.Skills = Skills;
        this.Item = Item;
    }
    
    public Unit(String Name, int Health, int MaxHealth, int Level, int PhysicalDamage, int MagicDamage, int PhysicalDefence, int MagicDefence, int Speed, ArrayList<Skill> Skills) {
        this.Name = Name;
        this.Health = Health;
        this.MaxHealth = MaxHealth;
        this.Level = Level;
        this.Exp = 0;
        this.MaxExp = 100 * (int)(Math.pow(Level, 0.9));
        this.PhysicalDamage = PhysicalDamage;
        this.MagicDamage = MagicDamage;
        this.PhysicalDefence = PhysicalDefence;
        this.MagicDefence = MagicDefence;
        this.Speed = Speed;
        this.Skills = Skills;
        this.Item = null;
    }
    
    // Name Methods
    public String getName() {
        return this.Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    // Health Methods
    public int getHealth() {
        return this.Health;
    }
    
    public void setHealth(int Health) {
        this.Health = Health;
        
        if (this.Health <= 0) {
            System.out.println(this.Name + " has been knocked out!");
        }
    }
    
    public void takeDamage(int Damage, boolean display) {
        setHealth(this.Health - Damage);
        
        if (display) {
            System.out.println(this.Name + " took " + Damage + " damage!");
        }
    }
    
    public void healHealth(int Healing, boolean display) {
        this.Health += Healing;
        
        if (display) {
            System.out.println(this.Name + " healed " + Healing + " health!");
        }
    }
    
    public int getMaxHealth() {
        return this.MaxHealth;
    }
    
    public void setMaxHealth(int MaxHealth) {
        this.MaxHealth = MaxHealth;
    }
    
    // Level Methods
    public int getLevel() {
        return this.Level;
    }
    
    public void setLevel(int Level) {
        int oldLevel = this.Level;
        
        int oldMaxHealth = this.MaxHealth;
        int oldPAttack = this.PhysicalDamage;
        int oldPDefence = this.PhysicalDefence;
        int oldMAttack = this.MagicDamage;
        int oldMDefence = this.MagicDefence;
        int oldSpeed = this.Speed;
        
        if (oldLevel < Level) {
            for (int i = oldLevel; i < Level; i++) {
                levelUp(false);
            }
            
            System.out.println(this.Name + " has leveled up to level " + Level + "!\n");
            
            System.out.println("Level " + oldLevel + " > " + this.Level);
            System.out.println("HP " + oldMaxHealth + " > " + this.MaxHealth + " (+" + (this.MaxHealth - oldMaxHealth) + ")");
            System.out.println("PATK " + oldPAttack + " > " + this.PhysicalDamage + " (+" + (this.PhysicalDamage - oldPAttack) + ")");
            System.out.println("PDEF " + oldPDefence + " > " + this.PhysicalDefence + " (+" + (this.PhysicalDefence - oldPDefence) + ")");
            System.out.println("MATK " + oldMAttack + " > " + this.MagicDamage + " (+" + (this.MagicDamage - oldMAttack) + ")");
            System.out.println("MDEF " + oldMDefence + " > " + this.MagicDefence + " (+" + (this.MagicDefence - oldMDefence) + ")");
            System.out.println("SPD " + oldSpeed + " > " + this.Speed + " (+" + (this.Speed - oldSpeed) + ")");
            
            System.out.println("\nExp needed for next level up: " + this.Exp + "/" + this.MaxExp);
        } else if (oldLevel > Level) {
            for (int i = oldLevel; i > Level; i--) {
                delevel(false);
            }
            
            System.out.println(this.Name + " has dropped to level " + this.Level + "!\n");
        }
    }
    
    public void levelUp(Boolean display) {
        if (display == null) {display = true;};
        
        int oldMaxHealth = this.MaxHealth;
        int oldPAttack = this.PhysicalDamage;
        int oldPDefence = this.PhysicalDefence;
        int oldMAttack = this.MagicDamage;
        int oldMDefence = this.MagicDefence;
        int oldSpeed = this.Speed;
        
        this.MaxHealth += 2;
        this.Health += 2;
        this.PhysicalDamage += 2;
        this.PhysicalDefence += 1;
        this.MagicDamage += 2;
        this.MagicDefence += 1;
        this.Speed += 2;
        
        this.Level++;
        
        this.MaxExp = 100 * (int)(Math.pow(Level, 1.2));
        
        if (display) {
            System.out.println(this.Name + " has leveled up to level " + this.Level + "!\n");
            
            System.out.println("Level " + (this.Level - 1) + " > " + this.Level);
            System.out.println("HP " + oldMaxHealth + " > " + this.MaxHealth + " (+" + (this.MaxHealth - oldMaxHealth) + ")");
            System.out.println("PATK " + oldPAttack + " > " + this.PhysicalDamage + " (+" + (this.PhysicalDamage - oldPAttack) + ")");
            System.out.println("PDEF " + oldPDefence + " > " + this.PhysicalDefence + " (+" + (this.PhysicalDefence - oldPDefence) + ")");
            System.out.println("MATK " + oldMAttack + " > " + this.MagicDamage + " (+" + (this.MagicDamage - oldMAttack) + ")");
            System.out.println("MDEF " + oldMDefence + " > " + this.MagicDefence + " (+" + (this.MagicDefence - oldMDefence) + ")");
            System.out.println("SPD " + oldSpeed + " > " + this.Speed + " (+" + (this.Speed - oldSpeed) + ")");
            
            System.out.println("\nExp needed for next level up: " + this.Exp + "/" + this.MaxExp);
        }
        
    }
    
    public void delevel(Boolean display) {
        if (display == null) {display = true;};
        
        int oldMaxHealth = this.MaxHealth;
        int oldPAttack = this.PhysicalDamage;
        int oldPDefence = this.PhysicalDefence;
        int oldMAttack = this.MagicDamage;
        int oldMDefence = this.MagicDefence;
        int oldSpeed = this.Speed;
        
        this.MaxHealth -= 2;
        this.Health -= 2;
        this.PhysicalDamage -= 2;
        this.PhysicalDefence -= 1;
        this.MagicDamage -= 2;
        this.MagicDefence -= 1;
        this.Speed -= 2;
        
        this.Level--;
        
        this.MaxExp = 100 * (int)(Math.pow(Level, 0.9));
        
        if (display) {
            System.out.println(this.Name + " has dropped to level " + this.Level + "!");
        }
    }
    
    // Exp Methods
    public int getExp() {
        return this.Exp;
    }
    
    public void setExp(int Exp) {
        this.Exp = Exp;
        
        if (this.Exp >= this.MaxExp) {
            int newLevel = Level;
            
            while (this.Exp >= this.MaxExp) {
                this.Exp -= this.MaxExp;
                
                newLevel++;
                this.MaxExp = 100 * (int)(Math.pow(newLevel, 0.9));
            }
            
            setLevel(newLevel);
        }
    }
    
    public void gainExp(int Exp) {
        System.out.print(this.Name + " has gained " + Exp + " Exp! ");
        
        if (this.Item != null) {
            if (this.Item.getEffect() == 8) {
                Exp *= this.Item.getModifier();
                System.out.println("(+" + (Exp - (int) (Exp / this.Item.getModifier())) + " with " + this.Item.getName() + "!)");
            }
        }
        
        Utils.blankInput();
        
        setExp(this.Exp + Exp);
    }
    
    public int getMaxExp() {
        return this.MaxExp;
    }
    
    public void setMaxExp(int MaxExp) {
        this.MaxExp = MaxExp;
    }
    
    // Stats Methods
    public int getPhysicalDamage() {
        return this.PhysicalDamage;
    }
    
    public void setPhysicalDamage(int PhysicalDamage) {
        this.PhysicalDamage = PhysicalDamage;
    }
    
    public int getMagicDamage() {
        return this.MagicDamage;
    }
    
    public void setMagicDamage(int MagicDamage) {
        this.MagicDamage = MagicDamage;
    }
    
    public int getPhysicalDefence() {
        return this.PhysicalDefence;
    }
    
    public void setPhysicalDefence(int PhysicalDefence) {
        this.PhysicalDefence = PhysicalDefence;
    }
    
    public int getMagicDefence() {
        return this.MagicDefence;
    }
    
    public void setMagicDefence(int MagicDefence) {
        this.MagicDefence = MagicDefence;
    }
    
    // Status Effect Methods
    public ArrayList<Status> getStatus() {
        return this.Statuses;
    }
    
    public void setStatus(ArrayList<Status> Statuses) {
        this.Statuses = Statuses;
    }
    
    public void addStatus(Status Statuses) {
        this.Statuses.add(Statuses);
    }
    
    public void removeStatus(Status Statuses) {
        this.Statuses.remove(Statuses);
    }
    
    public void clearStatuses() {
        this.Statuses.clear();
    }
    
    // Skills Methods
    public ArrayList<Skill> getSkills() {
        return this.Skills;
    }
    
    public void setSkills(ArrayList<Skill> Skills) {
        this.Skills = Skills;
    }
    
    public void setSkill(Skill skill, int index) {
        this.Skills.set(index, skill);
    }
    
    public void addSkill(Skill skill) {
        this.Skills.add(skill);
    }
    
    public void removeSkill(Skill skill) {
        this.Skills.remove(skill);
    }
    
    // Item Methods
    public Items getItem() {
        return this.Item;
    }
    
    public void setItem(Items Item) {
        this.Item = Item;
    }
    
    public String toString() {
        String finalString = "";
        
        finalString = this.Name + " Lvl " + this.Level + " (" + this.Exp + "/" + this.MaxExp + ")\nHP: " + this.Health + "/" + this.MaxHealth + "\n\nSkills:\n";
        
        for (int i = 0; i < 4; i++) {
            if (this.Skills.size() > i) {
                finalString += "BlankSkill\n";
            } else {
                finalString += "N/A\n";
            }
        }
        
        finalString += "\n";
        
        if (this.Item != null) {
            finalString += "Held Item: " + this.Item.getName();
        } else {
            finalString += "Held Item: N/A";
        }
        
        finalString += "\n\nPSTR: " + this.PhysicalDamage + "\nPDEF: " + this.PhysicalDefence + "\nMSTR: " + this.MagicDamage + "\nMDEF: " + this.MagicDefence + "\nSPD: " + this.Speed + "\n";
        
        return finalString;
    }
}