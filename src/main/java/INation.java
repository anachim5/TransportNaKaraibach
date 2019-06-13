/**Interfejs klasy {@link Nation}.
 * Zawiera metody:
 * {@link #createFleet()},tworzącą flotę danej nacji,
 * {@link #getFleet()},udoostępniającą flotę danej nacji,
 * {@link #getName()},udostępniającą nazwę nacji,
 * {@link #earnGold(int)},dodającą do skarbca nacji zarobione złoto,
 * {@link getTresure()},udostępniającą skarbiec nacji.
 */
public interface INation
{
    /**Metoda tworząca flotę*/
    void createFleet();
    /**Metoda udostępniająca flotę
     * @return obiekt floty nacji*/
    IFleet getFleet();
    /**Metoda udostępniająca nazwę nacji
     * @return nazwa nacji*/
    String getName();
    /**Metoda która dodaje zarobione złoto do skarbca nacji
     * @param amount ilosc zlota jaka jest dodana do skarbca*/
    void earnGold(int amount);
    /**Metoda udostępniająca skarbiec nacji
     * @return stan skarbca*/
    int getTresure();

}
