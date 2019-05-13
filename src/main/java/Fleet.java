import java.util.ArrayList;
//Klasa tworzaca flotę danego państwa
//Zawiera liste wszystkich statków jakie posiada to państwo
public class Fleet
{
private ArrayList<Ship> fleet;

    public Fleet()
    {
        this.fleet=new ArrayList<>();
    }
    public void addShip(Ship statek)
    {
        this.fleet.add(statek);
    }
    public void deleteShip(Ship statek)
    {
        this.fleet.remove(statek);
    }

}
