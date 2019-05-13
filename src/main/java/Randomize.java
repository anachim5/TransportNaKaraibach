import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class Randomize implements IRandomize
{
    //metoda tworząca Losową wielkosc mapy
    public static  int[] randomizeMapSize()
    {
        int x = (int) ((Math.random()*((512-128)+1))+128);
        int[] d={x,x};
        return d;
    }
    //Metoda wybierajaca losowa nazwe miasta
    public static String randomizeName()
    {
        ArrayList<String> namesOfCities=new ArrayList<>();
        namesOfCities.add("Askcl");
        namesOfCities.add("dfsclafsd");
        Random gen=new Random();
        return namesOfCities.get(gen.nextInt(namesOfCities.size()));
    }
    //Metoda wybierajaca losowa pozycje miasta na mapie
    public static int[] positionOfCity(Map mapa)
    {
        int x= (int) (Math.random()*mapa.getSize());
        int y= (int) (Math.random()*mapa.getSize());
        int[] d={x,y};
        return d;
    }
    //metoda tworząca losową cene produktów w miescie
    public static int randomPrice()
    {
        return (int)((Math.random()*30)+1);
    }
    //metoda tworząca losową ilosc miast
    public static int randomNumberOfCities()
    {
        Random gen = new Random();
        return gen.nextInt(10);
    }
    //metoda tworzaca losowa ilosc nacji
    public static int randomNumberOfNations()
    {
        Random gen = new Random();
        return gen.nextInt(5);

    }
    //metoda wybierajaca losowa nazwe nacji
    public static String nationName()
    {
        ArrayList<String> namesOfNations=new ArrayList<>();
        namesOfNations.add("Anglia");
        namesOfNations.add("Hiszpania");
        Random gen=new Random();
        return namesOfNations.get(gen.nextInt(namesOfNations.size()));
    }
    //metoda generujaca losowy poczatkowy skarb nacji
    public static  int randomizeTresure()
    {
        int x = (int) ((Math.random()*((30000-25000)+1))+25000);

        return x;
    }
    public static int randomAttack()
    {
        int x = (int) ((Math.random()*((30-15)+1))+15);

        return x;
    }
    public static int randomSpeed()
    {
        int x = (int) ((Math.random()*((30-15)+1))+15);

        return x;
    }
    public static int randomCapacity()
    {
        int x = (int) ((Math.random()*((300-50)+1))+50);

        return x;
    }
    public static int randomNumberOfShips()
    {
        int x = (int) ((Math.random()*((10-5)+1))+5);

        return x;
    }
    public static int randomTime()
    {
        int x = (int) ((Math.random()*((30000-25000)+1))+25000);

        return x;
    }
}
