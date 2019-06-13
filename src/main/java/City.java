/**Klasa definiująca obiekt miasta, które znajduje sie na mapie.
 * Miasta są celami statków.
 * {@link #City(String, int, int[])} jest konstruktorem obiektu,
 * {@link #getPosition()},udostępnia pozycję miasta,
 * {@link #getProductPrice()},udostępnia cenę za jaką w danym mieście sprzedawane są produkty.
 */
public class City implements ICity
{
    private final String name;
    private final int price;
    private final int[] position;
    /**Konstruktor tworzący obiekt
     * @param name nazwa miasta
     * @param price cena produktu w miescie
     * @param position pozycja miasta na mapie*/
    public City(String name,int price,int[] position)
    {
        this.name=name;
        this.price=price;
        this.position=position;
    }
    /**Metoda udostępniająca pozycję danego miasta*/
    public int[] getPosition()
    {
        return this.position;
    }
    /**Metoda udostępniająca cenę produktu w mieście*/
    public int getProductPrice()
    {
        return this.price;
    }

}
