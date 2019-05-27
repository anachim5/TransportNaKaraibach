/**Interfejs klasy {@link City}, zawierający metody{@link #getPosition()}
 * oraz metodę {@link #getProductPrice()}.
 */
public interface ICity
{
    /**Metoda udostępniająca pozycję danego miasta na mapie*/
    int[] getPosition();
    /**Metoda udostępniająca cenę sprzedaży produktu w danym mieście*/
    int getProductPrice();
}
