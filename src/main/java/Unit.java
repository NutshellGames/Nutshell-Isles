import java.util.ArrayList;
import java.util.Iterator;

public class Unit {
    private int Health;
    private int MaxHealth;
    private int Level;
    private int Exp;
    private int MaxExp;
    private String Name;
    private Races Race;
    private Role Job;
    private int PhysicalDamage;
    private int MagicDamage;
    private int PhysicalDefence;
    private int MagicDefence;
    private int Speed;
    private ArrayList<Status> Statuses = new ArrayList<>();
    private ArrayList<Skill> Skills;
    private Items Item;
    
    // Constructors
    public Unit(String Name, int Health, int MaxHealth, int Level, Races Race, Role Job, int PhysicalDamage, int MagicDamage, int PhysicalDefence, int MagicDefence, int Speed, ArrayList<Skill> Skills, Items Item) {
        this.Name = Name;
        this.Health = Health;
        this.MaxHealth = MaxHealth;
        this.Level = Level;
        this.Race = Race;
        this.Job = Job;
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

    public Unit(String Name, int Health, int MaxHealth, int Level, Races Race, Role Job, int PhysicalDamage, int MagicDamage, int PhysicalDefence, int MagicDefence, int Speed, ArrayList<Skill> Skills) {
        this.Name = Name;
        this.Health = Health;
        this.MaxHealth = MaxHealth;
        this.Level = Level;
        this.Race = Race;
        this.Job = Job;
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
    
    public void setHealth(int Health, boolean display) {
        this.Health = Health;
        
        if (display) {
            System.out.print(this.Name + "'s health is now ");
            if (this.Health > this.MaxHealth / 2) {
                System.out.println(Format.formatText(this.Health + "/" + this.MaxHealth, "green"));
            } else if (this.Health > this.MaxHealth / 10) {
                System.out.println(Format.formatText(this.Health + "/" + this.MaxHealth, "yellow"));
            } else {
                System.out.println(Format.formatText(this.Health + "/" + this.MaxHealth, "red"));
            }
        }
        
        if (this.Health <= 0) {
            System.out.println(this.Name + " has been knocked out!");
        }
    }

    public void setHealth(int Health) {setHealth(Health, true);}
    
    public void takeDamage(int Damage, boolean display) {
        if (display) {
            System.out.println(Format.formatText(this.Name + " took " + Damage + " damage!", "red"));
        }

        setHealth(this.Health - Damage);
    }

    public void takeDamage(int Damage) {takeDamage(Damage, true);}
    
    public void healHealth(int Healing, boolean overheal, boolean display) {
        if (display) {
            System.out.println(Format.formatText(this.Name + " healed " + Healing + " health!", "green"));
        }

        if (this.Health + Healing > this.MaxHealth && !overheal) {
            setHealth(this.MaxHealth);
        } else {
            setHealth(this.Health + Healing);
        }
    }

    public void healHealth(int Healing, boolean display) {healHealth(Healing, false, display);}
    public void healHealth(int Healing) {healHealth(Healing, false, true);}
    
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
            System.out.println("HP " + oldMaxHealth + " > " + this.MaxHealth + Format.formatText(" (+" + (this.MaxHealth - oldMaxHealth) + ")", "green"));
            System.out.println("PATK " + oldPAttack + " > " + this.PhysicalDamage + Format.formatText(" (+" + (this.PhysicalDamage - oldPAttack) + ")", "green"));
            System.out.println("PDEF " + oldPDefence + " > " + this.PhysicalDefence + Format.formatText(" (+" + (this.PhysicalDefence - oldPDefence) + ")", "green"));
            System.out.println("MATK " + oldMAttack + " > " + this.MagicDamage + Format.formatText(" (+" + (this.MagicDamage - oldMAttack) + ")", "green"));
            System.out.println("MDEF " + oldMDefence + " > " + this.MagicDefence + Format.formatText(" (+" + (this.MagicDefence - oldMDefence) + ")", "green"));
            System.out.println("SPD " + oldSpeed + " > " + this.Speed + Format.formatText(" (+" + (this.Speed - oldSpeed) + ")", "green"));
            
            System.out.println("\nExp needed for next level up: " + this.Exp + "/" + this.MaxExp);
        } else if (oldLevel > Level) {
            for (int i = oldLevel; i > Level; i--) {
                delevel(false);
            }
            
            System.out.println(Format.formatText(this.Name + " has dropped to level " + this.Level + "!\n", "red"));
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
    
    public void addStatus(Status status) {
        this.Statuses.add(status);

        System.out.println(this.Name + " has been afflicted with " + status.getName() + "!");
    }
    
    public void removeStatus(Status status) {
        this.Statuses.remove(status);

        System.out.println("The effects of " + Format.formatText(status.getName(), status.getColor()) + " have worn off on " + this.Name + "!");
    }

    public void tickAllStatuses() {
        if (!Statuses.isEmpty()) {
            Iterator<Status> iterator = this.Statuses.iterator();
            while (iterator.hasNext()) {
                Status status = iterator.next();
                status.statusTick(this);
                if (status.isExpired()) {
                    System.out.println("The effects of " + Format.formatText(status.getName(), status.getColor()) + " have worn off on " + this.Name + "!");
                    iterator.remove();
                }
            }
        }
    }

    public void tickStatus(Status status) {
        status.statusTick(this);
        
        System.out.println(status.isExpired());
        if (status.isExpired()) {
            removeStatus(status);
        }
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

    public void equipItem(Items Item) {
        unequipItem();
        this.Item = Item;
        Data.removeItem(Item);
    }

    public void unequipItem() {
        if (this.Item != null) {
            Data.addItem(this.Item);
        }

        this.Item = null;
    }

    // Race Methods
    public Races getRace() {
        return Race;
    }

    public double getRacismMultiplier(Unit other) {
        return Race.getRacismMultiplier(Race.getIndex(), other.getRace().getIndex());
    }
    
    public String toString() {
        String finalString = "";
        
        finalString = "(" + this.Race.getName() + ") " + this.Name + " Lvl " + this.Level + " (" + this.Exp + "/" + this.MaxExp + ")\n" + this.Job.getLvlPrefix() + " " + this.Job.getName() + "\nHP: ";

        if (this.Health > this.MaxHealth / 2) {
            finalString += Format.formatText(this.Health + "/" + this.MaxHealth, "green");
        } else if (this.Health > this.MaxHealth / 10) {
            finalString += Format.formatText(this.Health + "/" + this.MaxHealth, "yellow");
        } else {
            finalString += Format.formatText(this.Health + "/" + this.MaxHealth, "red");
        }
        
        finalString += "\n\nSkills:\n";
        
        for (int i = 0; i < 4; i++) {
            if (this.Skills.size() > i) {
                finalString += this.Skills.get(i).getName() + "\n";
            } else {
                finalString += "N/A\n";
            }
        }
        
        finalString += "\n";
        
        if (this.Item != null) {
            finalString += "Held Item: " + this.Item.getName(true);
        } else {
            finalString += "Held Item: N/A";
        }
        
        finalString += "\n\nPSTR: " + this.PhysicalDamage + "\nPDEF: " + this.PhysicalDefence + "\nMSTR: " + this.MagicDamage + "\nMDEF: " + this.MagicDefence + "\nSPD: " + this.Speed + "\n";
        
        return finalString;
    }
}