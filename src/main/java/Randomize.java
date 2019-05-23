import java.util.ArrayList;
import java.util.Random;

/**Klasa definiująca metody generujące losowe wartości dla elementów symulacji*/
public class Randomize
{
/**Ziarno generatora losowego*/
private static Seed seed;
private Random generator;
private ArrayList<String> CityNames;
private ArrayList<String> NationNames;


public Randomize(Seed seed)
{
    this.seed=seed;
    this.generator=new Random(seed.getSeed());
    this.CityNames=new ArrayList<>();
}
    /**Metoda tworząca Losową wielkosc mapy*/
    static int randomizeMapSize()
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
    int randomNumberOfCities()
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
    int randomTime()
    {
        int x=this.generator.nextInt(10000)+20000;
        return x;
    }
    /**metoda tworząca losową trasę do miasta na mapie*/
    int[] createRoute(IMap mapa)
    {   /**Wybieramy losowe miasto z listy
        * a następnie uzyskujemy jego pozycję
        *  którą zwraca metoda.
        */
        int x=this.generator.nextInt(mapa.getCities().size());
        ICity targetCity=(City) mapa.getCities().get(x);
        return targetCity.getPosition();
    }
    /**Metoda wybierajaca losowa pozycje miasta na mapie*/
    int[] positionOfCity(Map mapa)
    {
      int x=this.generator.nextInt(mapa.getSize());
      int y=this.generator.nextInt(mapa.getSize());
      int d[]={x,y};
      return d;
    }
}

