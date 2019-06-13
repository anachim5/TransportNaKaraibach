/**Interfejs klasy {@link City}, zawierający metody{@link #getPosition()}
 * oraz metodę {@link #getProductPrice()}.
 */
public interface ICity
{
    /**Metoda udostępniająca pozycję danego miasta na mapie
     * @return pozycja miasta*/
    int[] getPosition();
    /**Metoda udostępniająca cenę sprzedaży produktu w danym mieście
     * @return cena produktu w miescie*/
    int getProductPrice();
}
