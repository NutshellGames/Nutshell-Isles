public class Skill {
    private String Name;

    private int SkillType;
    /*
     * 1 - Attack
     * 2 - Defense
     * 3 - Status
     * 4 - Healing
     */
    
    private boolean Physical;
    // true = physical, false = magical
    
    private int Power;

    private int Accuracy;

    private int Speed;

    private int Targets;
    /*
     * 1 - Single Enemy
     * 2 - Multiple Enemies
     * 3 - Single Ally
     * 4 - Multiple Allies
     * 5 - Self
     */

    public Skill () {}

    public Skill(String Name, int SkillType, boolean Physical, int Power, int Accuracy, int Speed, int Targets) {
        this.Name = Name;
        this.SkillType = SkillType;
        this.Physical = Physical;
        this.Power = Power;
        this.Accuracy = Accuracy;
        this.Speed = Speed;
        this.Targets = Targets;
    }

    public String getName() {
        return this.Name;
    }

    public int getSkillType() {
        return this.SkillType;
    }
    
    public boolean isPhysical() {
        return this.Physical;
    }

    public int getPower() {
        return this.Power;
    }

    public int getAccuracy() {
        return this.Accuracy;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public int getTargets() {
        return this.Targets;
    }
}