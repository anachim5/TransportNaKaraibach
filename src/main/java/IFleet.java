import java.util.Iterator;

/**Interfejs klasy {@link Fleet}, który zawiera metody floty.
 * {@link #addShip(IShip)} dodaje statek do floty.
 * {@link #deleteShip(IShip)}usuwa statek z floty.
 * {@link #getFleetIterator()} udostepnia iterator floty.
 *
 */
public interface IFleet
{
    /**Metoda dodająca statek do floty.*/
    public void addShip(IShip statek);
    /**Metoda usuwająca statek z floty*/
    public void deleteShip(IShip statek);
    /**Metoda udostępniająca iterator floty*/
    public Iterator getFleetIterator();
}
