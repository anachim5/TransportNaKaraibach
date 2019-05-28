import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klasa "Map" definiuje pola i metody mapy na której odbywa sie cała symulacja.
 *  {@link #size} określa rozmiar mapy, która jest kwadratowa.
 *  {@link #cities} przechowuje obiekty miast, które znajdują się na mapie,
 *  {@link #nations} przechowuje obiekty nacji, które uczestniczą w symulacji na mapie.
 *  Konstruktor {@link #Map(int size)} inicjalizuje obiekt oraz ArrayList potrzebne do przechowywanie innych obiektów.
 *
 */
public class Map implements IMap
{
    private final int size;
    private ArrayList<ICity> cities;
    private ArrayList<INation> nations;
    public Map(int size)
    {
    this.cities=new ArrayList<ICity>();
    this.nations=new ArrayList<INation>();
    this.size=size;
    }
    /**Metoda Dodająca miasta*/
    public void AddCity(ICity Miasto)
    {
        this.cities.add(Miasto);
    }
    /**Metoda dodająca nację*/
    public void AddNation(INation nacja)
    {
        this.nations.add(nacja);
    }
    /**metoda która udostępniająca rozmiar mapy*/
    public int getSize()
    {
        return this.size;
    }
    /**metoda która udostępnia określoną nację*/
    public INation getNation(int nrNation)
    {
        return this.nations.get(nrNation);
    }
    /**Metoda udostępniająca Iterator nacji*/
    public Iterator getNationsIterator()
    {
        return nations.iterator();
    }
    /**Metoda udostępniająca listę miast*/
    public ArrayList getCities()
    {
        return this.cities;
    }
    /**Metoda wyszukująca miasto mając dane jego pozycję na mapie*/
    public ICity findCity(int[] position)
    {   Iterator citiesIterator=this.cities.iterator();
        while(citiesIterator.hasNext())
        {
            ICity foundcity =(ICity)citiesIterator.next();
            /**
             * Jeżeli pozycja miasta zgadza się z szukaną pozycją zwróc miasto,
             * w przeciwnym wypadku zwróc null
             */
            if(foundcity.getPosition()==position)
            {
                return foundcity;
            }
        }
        return null;
    }
}
