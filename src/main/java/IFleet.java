import java.util.Iterator;

/**Interfejs klasy {@link Fleet}, który zawiera metody floty.
 * {@link #addShip(IShip)} dodaje statek do floty.
 * {@link #deleteShip(IShip)}usuwa statek z floty.
 * {@link #getFleetIterator()} udostepnia iterator floty.
 *
 */
public interface IFleet
{
    /**Metoda dodająca statek do floty.
     * @param statek statek na którym ma być wykonana akcja*/
    public void addShip(IShip statek);
    /**Metoda usuwająca statek z floty
     * @param statek statek na którym ma być wykonana akcja*/
    public void deleteShip(IShip statek);
    /**Metoda udostępniająca iterator floty
     * @return Iterator floty*/
    public Iterator getFleetIterator();
}
