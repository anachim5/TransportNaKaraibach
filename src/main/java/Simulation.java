import java.util.Iterator;

/**
 * Klasa w której wykonywane są działania niezbędnę do przeprowadzenia symulacji.
 * Zawiera ona metody:
 * {@link #runSimulation(boolean random)},która uruchamia symulację,
 * {@param random} odpowiada za to czy cała symulacja ma być losowa czy użytkownik ustala jej parametry
 * {@link #createMap(int )},która tworzy mapę,
 * {@link #createNation(String,int)},która tworzy nację na mapie,
 * {@link #createCity(String,int,int[])},która umieszcza miasta na mapie,
 * {@link #createResults()},która tworzy wyniki.
 * konstruktor{@link #Simulation()}, który inicjalizuję mapę oraz wyniki.
 */
public class Simulation
{
    private IMap Mapa;
    private IResults Results;
    private IRandomize randomize;
    public Simulation()
    {
        this.Results=new Results();
        this.randomize=new Randomize();
    }

    private void createMap(int size)
    {
        this.Mapa=new Map(size);

    }
    private void createNation(String name,int tresure)
    {
        Nation nation=new Nation(name,tresure);
        nation.createFleet();
        this.Mapa.AddNation(nation);
    }
    private void createCity(String name,int price,int[]position)
    {
        this.Mapa.AddCity(new City(name,price,position));
    }
    private void createWarship(Nation nation,int attack,int capacity,int speed,String country,Map mapa,int Nr)
    {
        WarShip statek = new WarShip(attack,capacity,speed,country,mapa,Nr);

        nation.getFleet().addShip(statek);
    }
    private void createTradeShip(Nation nation,int attack,int capacity,int speed,String country,Map mapa,int Nr)
    {
        TradeShip statek = new TradeShip(attack,capacity,speed,country,mapa,Nr);

        nation.getFleet().addShip(statek);
    }


    public void runSimulation(boolean random)
    {
        if(random)
        {
            this.runRandomSimulation();
        }
        else
        {
            this.ActorSimulation();
        }
    }
    private void runRandomSimulation()
    {
        /**Symulacja ze wszystkimi parametrami losowymi które są tworzone przez klasę {@link Randomize}.
         * * Faza 1-Tworzenie obiektów symulacji:
         *          * 1.1.Tworzenie mapy
         */
         int sizeOfMap=this.randomize.randomizeMapSize();
         this.createMap(sizeOfMap);
         /**          * 1.2.Tworzenie miast*/
         int numberOfCities=this.randomize.randomNumberOfCities();
         for(int i=0;i<numberOfCities;i++)
         {
             String randomName=this.randomize.randomizeName();
             int randomPrice=this.randomize.randomPrice();
             int[] randomPosition=this.randomize.positionOfCity(this.Mapa);
             this.createCity(randomName,randomPrice,randomPosition);
         }
         /**          * 1.3.Tworzenie nacji*/
         int numberOfNations=this.randomize.randomNumberOfNations();
         int randomTresure=this.randomize.randomizeTresure();
         for(int i=0;i<numberOfNations;i++)
         {
             String randomName=this.randomize.nationName();
             this.createNation(randomName,randomTresure);
         }
         /**          * 1.4.Tworzenie statków*/
        Iterator nationsIterator=this.Mapa.getNationsIterator();
        int randomNumberOfWarships=(int)this.randomize.randomNumberOfShips()/2;
        int randomNumberOfTradeShips=(int)this.randomize.randomNumberOfShips()/2;
        int nr=1;
        while(nationsIterator.hasNext())
        {
            Nation nation=(Nation)nationsIterator.next();
            for (int i = 0; i <randomNumberOfTradeShips ; i++)
            {

                int attack=this.randomize.randomAttack();
                int capacity=this.randomize.randomCapacity();
                int speed=this.randomize.randomSpeed();
                String country=nation.getName();
                this.createTradeShip(nation,attack,capacity,speed,country,this.Mapa,nr);
                nr++;
            }
            for (int i = 0; i <randomNumberOfWarships ; i++)
            {

                int attack=this.randomize.randomAttack();
                int capacity=this.randomize.randomCapacity();
                int speed=this.randomize.randomSpeed();
                String country=nation.getName();
                this.createWarship(nation,attack,capacity,speed,country,this.Mapa,nr);
                nr++;
            }
        }
        /** Faza 2-Symulacja:
         * Każdy z warunków sprawdzany jest na każdym ze statków.*/
        while(nationsIterator.hasNext())
        {
            Nation nation=(Nation) nationsIterator.next();
            Iterator fleetIterator=nation.getFleet().getFleetIterator();
            while (fleetIterator.hasNext())
            {
                IShip ship=(Aship) fleetIterator.next();
            /** 2.1 Sprawdzenie czy statek ma trasę,jeśli nie nadanie mu trasy.*/

            }
        }
        /**         * 2.1 Sprawdzenie czy statek ma trasę,jeśli nie nadanie mu trasy.*/
         /**          * 2.2 Sprawdzenie czy statek jest w mieście.*/
         /**         * 2.3 Sprawdzenie czy statek jest w walce z innym.*/
         /**          * 2.4 Ruch statku jeśli żaden z powyższych warunków nie został spełniony.*/
         /**          * Co określoną ilość ticków do pliku zapisywany jest stan skarbca każdej z nacji.*/
         /** * Faza 3-Podsumowanie:
         *          * Do pliku drukowane są końcowe wyniki symulacji.*/


    }
    private void ActorSimulation()
    {
        /**Symulacja w której aktor wybiera parametry symulacji
         * Faza 1-Tworzenie obiektów symulacji:
         * 1.1.Tworzenie mapy
         * 1.2.Tworzenie miast
         * 1.3.Tworzenie nacji
         * 1.4.Tworzenie statków
         * Faza 2-Symulacja:
         * Każdy z warunków sprawdzany jest na każdym ze statków.
         * 2.1 Sprawdzenie czy statek ma trasę,jeśli nie nadanie mu trasy.
         * 2.2 Sprawdzenie czy statek jest w mieście.
         * 2.3 Sprawdzenie czy statek jest w walce z innym.
         * 2.4 Ruch statku jeśli żaden z powyższych warunków nie został spełniony.
         * Co określoną ilość ticków do pliku zapisywany jest stan skarbca każdej z nacji.
         * Faza 3-Podsumowanie:
         * Do pliku drukowane są końcowe wyniki symulacji.
         * */


    }
}
