import java.util.ArrayList;
import java.util.HashMap;

public class Relationships {
    private ArrayList<Unit> party = Data.getParty();
    private ArrayList<Unit> innMembers = Data.getInnMembers();

    private HashMap<Unit, Tuple<String, Integer>> interactionLog = new HashMap<Unit, Tuple<String, Integer>>();
    private HashMap<Unit, Integer> opinions = new HashMap<Unit, Integer>();

    private boolean inParty;
    private boolean inInn;
    private boolean isEnemy;

    public Relationships(Unit unit) {
        inParty = party.contains(unit);
        inInn = innMembers.contains(unit);
        isEnemy = !inParty && !inInn;
    }

    public void setOpinion(Unit unit, int opinion) {
        opinions.put(unit, opinion);
    }

    public int getOpinion(Unit unit) {
        return opinions.getOrDefault(unit, 0);
    }

    public void modifyOpinion(Unit unit, int delta) {
        opinions.put(unit, getOpinion(unit) + delta);
    }

    public void interaction(Unit mainUnit, Unit unit, String action, int effect) {
        interactionLog.put(unit, new Tuple<String, Integer>(action, effect));

        double racismModifier = mainUnit.getRacismMultiplier(unit);

        if 
        modifyOpinion(unit, effect);
    }
}
