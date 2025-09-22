public class Races {
    private final String name;
    private final int index;

    /*
     * Humans: 0
     * Elves: 1
     * Dwarves: 2
     * Orcs: 3
     * Goblins: 4
     * Undead: 5
     * Halflings: 6
     * Gnomes: 7
     * Trolls: 8
     */

    public Races(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    // Base stat multipliers for each (HP, MATK, PATK, MDEF, PDEF, SPD)
    private double[][] raceBaseMults = {
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0}, // Humans
        {0.8, 1.2, 0.8, 1.1, 0.9, 1.2}, // Elves
        {1.2, 0.8, 1.2, 1.3, 1.4, 0.7}, // Dwarves
        {1.3, 0.7, 1.4, 0.9, 1.2, 0.8}, // Orcs
        {0.8, 0.9, 0.7, 0.8, 0.7, 1.3}, // Goblins
        {1.0, 0.6, 0.6, 1.5, 1.5, 0.5}, // Undead
        {0.7, 0.8, 0.8, 0.7, 0.6, 1.5}, // Halflings
        {0.9, 1.1, 0.9, 1.0, 1.0, 1.1}, // Gnomes
        {1.5, 0.5, 1.5, 1.4, 1.3, 0.6}  // Trolls
    };

    public double[] getRaceBaseMults(int raceIndex) {
        if (raceIndex < 0 || raceIndex >= raceBaseMults.length) {
            throw new IllegalArgumentException("Invalid Race!");
        }
        return raceBaseMults[raceIndex];
    }

    // Relationship multipliers for inter-racial interactions (0 to 1 scale)
    private double[][] racismChart = {
        {1.0, 0.8, 0.9, 0.7, 0.5, 0.5, 0.9, 0.9, 0.4}, // Humans
        {0.8, 1.0, 0.7, 0.5, 0.5, 0.6, 0.9, 0.9, 0.5}, // Elves
        {0.9, 0.7, 1.0, 0.6, 0.5, 0.5, 0.8, 0.9, 0.6}, // Dwarves
        {0.4, 0.7, 0.6, 0.9, 0.4, 0.6, 0.6, 0.7, 0.4}, // Orcs
        {0.6, 0.5, 0.8, 0.6, 1.0, 0.5, 0.7, 0.8, 0.5}, // Goblins
        {0.2, 0.4, 0.4, 0.4, 0.4, 1.0, 0.4, 0.4, 0.4}, // Undead
        {0.9, 0.9, 0.6, 0.8, 0.5, 0.6, 1.0, 0.9, 0.7}, // Halflings
        {0.8, 0.7, 0.8, 0.7, 0.4, 0.7, 0.9, 1.0, 0.7}, // Gnomes
        {0.4, 0.4, 0.4, 0.9, 0.7, 0.6, 0.5, 0.7, 1.0}  // Trolls
    };

    public double getRacismMultiplier(int raceA, int raceB) {
        if (raceA < 0 || raceA >= racismChart.length || raceB < 0 || raceB >= racismChart.length) {
            throw new IllegalArgumentException("Invalid Race!");
        }
        return racismChart[raceA][raceB];
    }
}
