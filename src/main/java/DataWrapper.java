import java.util.ArrayList;

public class DataWrapper {
    public String Date;
    public String Version;
    public ArrayList<Unit> Party;
    public ArrayList<Unit> InnMembers;
    public ArrayList<Items> Items;

    public String toString() {
        return "DataWrapper{" +
                "Date='" + Date + '\'' +
                ", Version='" + Version + '\'' +
                ", Party=" + Party +
                ", InnMembers=" + InnMembers +
                ", Items=" + Items +
                '}';
    }
}