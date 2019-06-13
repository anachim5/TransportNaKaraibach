import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klasa definiująca flotę danego państwa
 * Zawiera liste wszystkich statków jakie posiada to państwo.
 * Zawiera{@link #Fleet()} konstruktor tworzący flotę oraz metody:
 * {@link #addShip(IShip)},dodający statek do floty,
 * {@link #deleteShip(IShip)},usuwający statek z floty,
 * {@link #getFleetIterator()},udostępniającą iterator floty.
 */
public class Fleet implements IFleet
{   /**Lista statków we flocie*/
    private ArrayList<IShip> fleet;
    /** Konstruktor tworzący flotę.*/
    public Fleet()
    {
        this.fleet=new ArrayList<>();
    }
    /**Metoda dodająca statek do floty.*/
    public void addShip(IShip statek)
    {
        this.fleet.add(statek);
    }
    /**Metoda usuwająca statek z floty*/
    public void deleteShip(IShip statek)
    {
        this.fleet.remove(statek);
    }
    /**Metoda udostępniająca iterator floty*/
    public Iterator getFleetIterator(){return this.fleet.iterator();}

}
