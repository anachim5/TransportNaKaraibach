import java.util.ArrayList;
import java.util.Random;

/**Klasa definiująca metody generujące losowe wartości dla elementów symulacji*/
public class Randomize implements IRandomize
{
/**Ziarno generatora losowego*/
private static ISeed seed;
/**Generator losowy*/
private Random generator;
/**Lista nazwa miast*/
private ArrayList<String> CityNames;
/**Lista nazw państw*/
private ArrayList<String> NationNames;

/**Konstruktor*
 * @param seed ziarno generatora losowego
 */
public Randomize(ISeed seed)
{
    this.seed=seed;
    this.generator=new Random(this.seed.getSeed());
    this.CityNames=new ArrayList<>();
    this.NationNames=new ArrayList<>();
    this.AddCityNames();
    this.AddNationNames();
}
    /**Metoda tworząca Losową wielkosc mapy*/
    public int randomizeMapSize()
    {
        int x=this.generator.nextInt(512)+128;
        return x;
    }
    /**Metoda wybierajaca losowa nazwe miasta*/
    public String randomizeName()
    {
    int x=this.generator.nextInt(this.CityNames.size());
        return this.CityNames.get(x);
    }
    /**metoda tworząca losową cene produktów w miescie*/
    public int randomPrice()
    {
        int x=this.generator.nextInt(50)+2;
        return x;
    }
    /**metoda tworząca losową ilosc miast*/
    public int randomNumberOfCities()
    {
        int x=this.generator.nextInt(10)+1;
        return x;
    }
    /**metoda tworzaca losowa ilosc nacji*/
    public int randomNumberOfNations()
    {
        int x=this.generator.nextInt(5)+1;
        return x;
    }
    /**metoda wybierajaca losowa nazwe nacji*/
    public String nationName()
    {
        int x=this.generator.nextInt(this.NationNames.size());
        return this.CityNames.get(x);
    }
    /**metoda generujaca losowy poczatkowy skarb nacji*/
    public int randomizeTresure()
    {
        int x=this.generator.nextInt(30000)+1;
        return x;
    }
    /**metoda tworzaca losowa wartosc ataku statku*/
    public int randomAttack()
    {
        int x=this.generator.nextInt(30)+1;
        return x;
    }
    /**metoda tworzaca losowa predkosc statku*/
    public int randomSpeed()
    {
        int x=this.generator.nextInt(30)+1;
        return x;
    }
    /**metoda tworząca losową pojemnośc statku*/
    public int randomCapacity()
    {
        int x=this.generator.nextInt(150)+20;
        return x;
    }
    /**metoda tworząca losową ilość statków we flocie*/
    public int randomNumberOfShips()
    {
        int x=this.generator.nextInt(15)+2;
        return x;
    }
    /**metoda tworząca losową ilość ticków symulacji*/
    public int randomTime()
    {
        int x=this.generator.nextInt(10000)+20000;
        return x;
    }
    /**metoda tworząca losową trasę do miasta na mapie*/
    public int[] createRoute(IMap mapa)
    {   /**Wybieramy losowe miasto z listy
        * a następnie uzyskujemy jego pozycję
        *  którą zwraca metoda.
        */
        int x=this.generator.nextInt(mapa.getCities().size());
        ICity targetCity=(City) mapa.getCities().get(x);
        return targetCity.getPosition();
    }
    /**Metoda wybierajaca losowa pozycje miasta na mapie*/
    public int[] posofCity(IMap mapa)
    {
      int x=this.generator.nextInt(mapa.getSize());
      int y=this.generator.nextInt(mapa.getSize());
      int d[]={x,y};
      return d;
    }
    private void AddCityNames()
    {
        this.CityNames.add("Havana");
        this.CityNames.add("Varadero");
        this.CityNames.add("Santiago De Cuba");
        this.CityNames.add("Port-Au-Prince");
        this.CityNames.add("Montego Bay");
        this.CityNames.add("Trinidad");
        this.CityNames.add("Cienfuegos");
        this.CityNames.add("Moa");
        this.CityNames.add("Rum Point");
        this.CityNames.add("Blossom Village");
        this.CityNames.add("Gros Mangle");
        this.CityNames.add("San Juan");
        this.CityNames.add("Flamenco");
        this.CityNames.add("Esperanza");
        this.CityNames.add("Christiansted");
        this.CityNames.add("Nassau");
        this.CityNames.add("Rocker`s");
        this.CityNames.add("Gregory Town");
        this.CityNames.add("Key West");
        this.CityNames.add("Roseau");
        this.CityNames.add("Grand-Bourg");
        this.CityNames.add("Pointe-a-Pitre");
        this.CityNames.add("Basseterre");
        this.CityNames.add("Gustavia");
        this.CityNames.add("Virgin Gorda");
    }
    private void AddNationNames()
    {
        this.NationNames.add("Cuba");
        this.NationNames.add("Dominika");
        this.NationNames.add("Spain");
        this.NationNames.add("Czarnobrody");
        this.NationNames.add("Kraken");
        this.NationNames.add("Virgin Islands");
        this.NationNames.add("USA");
        this.NationNames.add("England");
        this.NationNames.add("Great Britain");
        this.NationNames.add("Anguilla");
        this.NationNames.add("Gwadelupe");
        this.NationNames.add("Saint Lucia Tribe");
        this.NationNames.add("Indians");
        this.NationNames.add("Red Necks");
        this.NationNames.add("Nation Name");
        this.NationNames.add("Niezrzeszeni piraci morza Karaibskiego");
        this.NationNames.add("I`m drowning");

    }
}

