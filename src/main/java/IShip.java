/** Interfejs  abstakcyjnej klasy {@link Aship}, która definiuje statki, które są głownymi obiektami symulacji.
 *{@link #AddRoute(int[])} Metoda dodająca trasę i uzupełniająca ekwipunek.
 * {@link #getRoute()}Metoda udostępniająca cel statku
 * {@link #deleteRoute()}Metoda która czyści drogę i ekwipunek.
 * {@link #getPosition()}Metoda która udosępnia pozycję statku na mapie.
 */
public interface IShip
{
    /**Metoda pozwalająca na dodanie trasy,przy każdym dodaniu trasy jako że statek jest w mieście uzupełniany jest ekwipunek*
     @param route cel statku
     */
    public void AddRoute(int[] route);
    /**Metoda która udostępnia cel statku*
     * @return cel statku
     * */
    public int[] getRoute();
    /**Metoda, która usuwa drogę oraz czyści ekwipunek*/
    public void deleteRoute();
    /**metoda która uzyskuje pozycję statyku w danym ticku
     * @return pozycja statku*/
    public int[] getPosition();
    /**metoda która ustala pozycję statku*
     * @param position pozycja statku
     */
    public void setPosition(int[]position);
    /**metoda która udostępnia prędkość statku
     * @return predkość statku*/
    int getSpeed();
    /**metoda która udostępnia atak
     * @return atak statku*/
    int getAttack();
    /**metoda która udostępnia pojemność statku
     * @return pojemnosc statku*/
    int getCapacity();
    /**metoda która zeruje ekwipunek statku*/
    void resetInventory();
    /**Metoda która zwraca nację do której należy statek
     * @return nacja statku*/
    String getCountry();
    /**Metoda która zwraca numer statku
     * @return numer statku*/
    int getNr();
    /**Metoda która zwraca ładunek statku
     * @return ładunek statku*/
    public int getInventory();
    /**Metoda która sprawdza czy statek ma trasę
     * @return stan trasy statku*/
    public boolean hasRoute();
    /**Metoda która porusza statek*/
    public void move();
    /**Metoda która sprawdza czy statek jest w mieście
     * @return dokowanie statku*/
    public boolean inCity();
    /**Metoda która definiuje walkę statków
     * @param mapa mapa na której dzieje się symulacja*/
    void fight(IMap mapa);

}
