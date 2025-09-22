public class Role {
    private final String name;
    private final int index;
    private int exp = 0;
    private int level = 1;

    public Role(String name, int index, int level) {
        this.name = name;
        this.index = index;
        this.level = level;
    }

    public Role(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public Role(String name) {
        this.name = name;
        this.index = 0; // Default index for roles without a specific index
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public int getExp() {
        return exp;
    }

    public void addExp(int exp) {
        this.exp += exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Bonuses for each role
    // The order of bonuses is: [HP, MATK, PATK, MDEF, PDEF, SPD]
    private final double[][] roleLvlUpBonuses = {
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0}, // Drifter
        {1.1, 1.0, 1.2, 1.0, 1.0, 1.0}, // Swordsman
        {1.2, 0.9, 1.4, 1.0, 1.1, 1.2}, // Warrior
        {1.5, 0.8, 1.5, 1.2, 1.5, 0.7}, // Knight
        {2.0, 1.2, 1.5, 1.5, 2.0, 0.5}, // Holy Knight
        {1.2, 0.6, 1.7, 0.9, 1.0, 1.3}, // Barbarian
        {1.4, 0.4, 2.0, 0.75, 1.2, 1.5}, // Savage
        {0.8, 1.2, 0.7, 1.1, 0.7, 0.9}, // Mage
        {0.8, 1.4, 0.7, 1.3, 0.7, 0.9}, // Wizard
        {1.0, 1.5, 0.75, 1.5, 0.75, 0.8}, // Sorcerer
        {1.2, 1.7, 0.85, 2.0, 0.8, 0.7}, // Sorcerer Supreme
        {0.8, 2.0, 0.5, 1.4, 0.5, 0.8}, // Dark Wizard
        {0.7, 2.5, 0.25, 1.6, 0.35, 0.6}, // Necromancer
        {0.9, 1.0, 1.0, 1.1, 0.8, 1.2}, // Bowman
        {0.9, 1.0, 1.0, 1.1, 0.8, 1.3}, // Archer
        {0.8, 1.0, 1.3, 1.1, 0.7, 1.5}, // Ranger
        {0.7, 1.1, 3.0, 1.1, 0.7, 0.5}, // Sniper
        {0.9, 1.2, 1.3, 1.1, 0.9, 1.7}, // Rogue
        {0.9, 1.3, 1.75, 1.1, 0.9, 1.5}, // Assassin
        {0.8, 1.2, 0.8, 1.0, 0.7, 0.9}, // Healer
        {0.8, 1.4, 0.8, 1.2, 0.7, 0.9}, // Cleric
        {0.9, 1.6, 0.9, 1.5, 0.8, 0.6}, // Bishop
        {1.0, 2.0, 1.0, 2.0, 1.0, 0.4}, // Archbishop
        {0.7, 1.3, 0.8, 1.0, 0.8, 1.2}, // Alchemist
        {0.7, 1.3, 1.0, 1.0, 0.8, 1.3}, // Potions Master
        {1.1, 1.1, 1.1, 1.1, 1.1, 1.1}, // Nut of All Trades
        {1.3, 1.3, 1.3, 1.3, 1.3, 1.3}, // Peanut Butter
        {1.5, 1.5, 1.5, 1.5, 1.5, 1.5}, // Nutella Champion
    }; // There are 28 roles/types defined

    public double[] getRoleLvlUpBonuses() {
        if (index < 0 || index >= roleLvlUpBonuses.length) {
            return roleLvlUpBonuses[0]; // Default bonuses if index is out of bounds
        }
        return roleLvlUpBonuses[index];
    }

    private final String[] lvlPrefixes = {
        "Novice", // Level 1
        "Apprentice", // Level 2
        "Adept", // Level 3
        "Professional", // Level 4
        "Expert", // Level 5
        "Master", // Level 6
    };

    public String getLvlPrefix() {
        if (level <= 0) {
            return lvlPrefixes[0]; // Default prefix for invalid levels
        } else if (level >= lvlPrefixes.length) {
            return lvlPrefixes[lvlPrefixes.length - 1]; // Highest prefix for levels beyond defined range
        }
        return lvlPrefixes[level - 1];
    }

    public final int[] roleExpReqs = {
        100, // Default
        150, // Swordsman
        200, // Warrior
        300, // Knight
        500, // Holy Knight
        300, // Barbarian
        500, // Savage
        150, // Mage
        200, // Wizard
        300, // Sorcerer
        500, // Sorcerer Supreme
        300, // Dark Wizard
        400, // Necromancer
        150, // Bowman
        200, // Archer
        300, // Ranger
        500, // Sniper
        300, // Rogue
        500, // Assassin
        150, // Healer
        200, // Cleric
        300, // Bishop
        500, // Archbishop
        300, // Alchemist
        500, // Potions Master
        300, // Nut of All Trades
        500, // Peanut Butter
        1000, // Nutella Champion
    };

    public int getExpReq() {
        if (index < 0 || index >= roleExpReqs.length) {
            return roleExpReqs[0]; // Default exp requirement if index is out of bounds
        }
        return roleExpReqs[index] * (int)(Math.pow(level, 0.9)); // Exp requirement increases with level
    }

    public void levelUp() {
        if (exp >= getExpReq()) {
            exp -= getExpReq();
            level++;
        }
    }

    public final int[][] promotesInto = {
        {1, 7, 13, 19}, // Default (Swordsman, Mage, Bowman, Healer)
        {2}, // Swordsman (Warrior)
        {3, 5}, // Warrior (Knight, Barbarian)
        {4}, // Knight (Holy Knight)
        {-1}, // Holy Knight (Does not evolve further)
        {6}, // Barbarian (Savage)
        {-1}, // Savage (Does not evolve further)
        {8}, // Mage (Wizard)
        {9, 11}, // Wizard (Sorcerer, Dark Wizard)
        {10}, // Sorcerer (Sorcerer Supreme)
        {-1}, // Sorcerer Supreme (Does not evolve further)
        {12}, // Dark Wizard (Necromancer)
        {-1}, // Necromancer (Does not evolve further)
        {14}, // Bowman (Archer)
        {15, 17}, // Archer (Ranger, Rogue)
        {16}, // Ranger (Sniper)
        {-1}, // Sniper (Does not evolve further)
        {18}, // Rogue (Assassin)
        {-1}, // Assassin (Does not evolve further)
        {20}, // Healer (Cleric)
        {21, 23}, // Cleric (Bishop, Alchemist)
        {22}, // Bishop (Archbishop)
        {-1}, // Archbishop (Does not evolve further)
        {24}, // Alchemist (Potions Master)
        {-1}, // Potions Master (Does not evolve further)
        {26}, // Nut of All Trades (Peanut Butter)
        {27}, // Peanut Butter (Nutella Champion)
        {-1}  // Nutella Champion (Does not evolve further)
    };

    public int[] getPromotesInto() {
        if (index < 0 || index >= promotesInto.length) {
            return promotesInto[0]; // Default promotion if index is out of bounds
        }
        
        return promotesInto[index];
    };
}
