//Klasa deklarująca wszysktie metody potrzebne do symulacji
public class Simulation
{
//1.Tworzenie mapy
public static Map createMap(int[] size)
    {
    return new Map(size);
    }
//2.Tworzenia miasta
public static City createCity(Map mapa)
    {
        String name = Randomize.randomizeName();
        int[] position=Randomize.positionOfCity(mapa);
        int price=Randomize.randomPrice();
        return new City(name,price,position);
    }
//3.Tworzenie nacji
public static Nation createNation()
    {
        String name=Randomize.nationName();
        int tresure=Randomize.randomizeTresure();
        return new Nation(name,tresure);
    }
public static Ship createShip(String country)
    {
        int attack=Randomize.randomAttack();
        int capacity=Randomize.randomCapacity();
        int speed=Randomize.randomSpeed();
        return new Ship(attack,capacity,speed,country);
    }
}

