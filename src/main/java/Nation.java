/**Klasa definiująca nację dla których pracują statki.
 * Każda z nacji ma swoją flotę {@link IFleet}.
 * Klasa zawiera pola deklarujące jej nazwę oraz skarbiec.
 * Zawiera metody:
 * {@link #Nation(String, int)},kontruktor tworzący nację,
 * {@link #createFleet()},metodę tworzącą flotę,
 * {@link #getFleet()},metoda udostępniająca obiekt floty,
 * {@link #getName()},metoda udostępniająca nazwę nacji,
 * {@link #earnGold(int)},metoda która dodaje zarobioną ilość złota do skarbu nacji.
 * {@link #getTresure()},metoda  udostępniająca skarbiec nacji.
 */
public class Nation implements INation
{
    private final String name;
    private int tresure;
    private Fleet fleet;
    /**Konstruktor nacji
     * @param name nazwa nacji
     * @param tresure poczatkowa wartosc skarbca nacji*/
    public Nation(String name,int tresure)
    {
        this.name = name;
        this.tresure = tresure;
    }
    /**Metoda tworząca flotę*/
    public void createFleet()
    {
        this.fleet=new Fleet();
    }
    /**Metoda udostępniająca flotę*/
    public IFleet getFleet()
    {
        return (IFleet)this.fleet;
    }
    /**Metoda udostępniająca nazwę nacji*/
    public String getName()
    {
        return this.name;
    }
    /**Metoda która dodaje zarobione złoto do skarbca nacji*/
    public void earnGold(int amount)
    {
        this.tresure+=amount;
    }
    /**Metoda udostępniająca skarbiec nacji*/
    public int getTresure()
    {
        return this.tresure;
    }
}
