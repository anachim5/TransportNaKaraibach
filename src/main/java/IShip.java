/** Interfejs  abstakcyjnej klasy {@link Aship}, która definiuje statki, które są głownymi obiektami symulacji.
 *{@link #AddRoute(int[])} Metoda dodająca trasę i uzupełniająca ekwipunek.
 * {@link #getRoute()}Metoda udostępniająca cel statku
 * {@link #deleteRoute()}Metoda która czyści drogę i ekwipunek.
 * {@link #getPosition()}Metoda która udosępnia pozycję statku na mapie.
 */
public interface IShip
{
    /**Metoda pozwalająca na dodanie trasy,przy każdym dodaniu trasy jako że statek jest w mieście uzupełniany jest ekwipunek*/
    public void AddRoute(int[] route);
    /**Metoda która udostępnia cel statku*/
    public int[] getRoute();
    /**Metoda, która usuwa drogę oraz czyści ekwipunek*/
    public void deleteRoute();
    /**metoda która uzyskuje pozycję statyku w danym ticku*/
    public int[] getPosition();
    /**metoda która uzyskuje pozycję statyku w danym ticku*/
    public int[] getPosition();
    /**metoda która ustala pozycję statku*/
    public void setPosition(int[]position);
    /**metoda która udostępnia prędkość statku*/
    int getSpeed();
    /**metoda która udostępnia atak*/
    int getAttack();
    /**metoda która udostępnia pojemność statku*/
    int getCapacity();
    /**metoda która zeruje ekwipunek statku*/
    void resetInventory();
    /**Metoda która zwraca nację do której należy statek*/
    String getCountry();
    /**Metoda która zwraca numer statku*/
    int getNr();
    /**Metoda która zwraca ładunek statku*/
    public int getInventory();
}
