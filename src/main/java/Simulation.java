import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Klasa w której wykonywane są działania niezbędnę do przeprowadzenia symulacji.
 * Zawiera ona metody:
 * {@link #runSimulation(boolean random)},która uruchamia symulację,
 * {@link #createMap(int )},która tworzy mapę,
 * {@link #createNation(String,int)},która tworzy nację na mapie,
 * {@link #createCity(String,int,int[])},która umieszcza miasta na mapie,
 * konstruktor{@link #Simulation(ISeed seed)}, który inicjalizuję mapę oraz wyniki.
 */
public class Simulation
{   /**Mapa na której dzieje się symulacja*/
    private IMap Mapa;
    /**Generator wyników*/
    private IResults Results;
    /**Generator wartości losowych*/
    private IRandomize randomize;
    /**Ziarno generatora losowego*/
    private ISeed seed;
    /**Obiekt wczytujący zmienne*/
    private Scanner scanner;
    /**Konstruktor klasy symulacja*
     * @param seed ziarno generatora losowego.
     */

    public Simulation(ISeed seed)
    {   this.seed=seed;
        this.Results=new Results();
        this.randomize=new Randomize(this.seed);
        this.scanner = new Scanner(System.in);
    }
    /**Metoda która tworzy mapę w symulacji
     * @param size rozmiar mapy*/
    private void createMap(int size)
    {
        this.Mapa=new Map(size);

    }
    /**Metoda, która tworzy nację w symulacji*
     * @param name nazwa nacji
     * @param tresure skarbiec nacji
     */

    private void createNation(String name,int tresure)
    {
        Nation nation=new Nation(name,tresure);
        nation.createFleet();
        this.Mapa.AddNation(nation);
    }
    /**Metoda która tworzy miasto w symulacji
     * @param name nazwa miasta
     * @param price cena produktu w miescie
     * @param position pozycja miasta na mapie*/

    private void createCity(String name,int price,int[]position)
    {
        this.Mapa.AddCity(new City(name,price,position));
    }
    /**Metoda, która tworzy statek bojowy
     * @param nation nacja dla której pływa statek
     * @param attack atak statku
     * @param capacity pojemnosc statku
     * @param speed predkosc statku
     * @param country nacja do której należy statek
     * @param mapa mapa na której znajduje sie statek
     * @param Nr numer statku*/

    private void createWarship(Nation nation,int attack,int capacity,int speed,String country,IMap mapa,int Nr)
    {
        WarShip statek = new WarShip(attack,capacity,speed,country,mapa,Nr);

        nation.getFleet().addShip(statek);
    }
    /**Metoda która tworzy statek kupiecki
     * @param nation nacja dla której pływa statek
     * @param attack atak statku
     * @param capacity pojemnosc statku
     * @param speed predkosc statku
     * @param country nacja do której należy statek
     * @param mapa mapa na której znajduje sie statek
     * @param Nr numer statku*/
    private void createTradeShip(Nation nation,int attack,int capacity,int speed,String country,IMap mapa,int Nr)
    {
        TradeShip statek = new TradeShip(attack,capacity,speed,country,mapa,Nr);

        nation.getFleet().addShip(statek);
    }

    /**Metoda która uruchamia symulację
     * @param random decyduje czy symulacja ma być całkowicie losowa czy parametry mają być ustalone przez aktora*/
    public void runSimulation(boolean random)
    {
        if(random==true)
        {
            this.runRandomSimulation();
        }
        else
        {
            this.ActorSimulation();
        }
    }
    /**Metoda, która uruchamia w symulację z wybieralnymi parametrami*/
    private void ActorSimulation()
    {
        /**Symulacja z parametrami  które są wybierane  przez aktora.
         * * Faza 1-Tworzenie obiektów symulacji:
         *          * 1.1.Tworzenie mapy
         */
        System.out.println("Podaj rozmiar mapy");
        int sizeOfMap=scanner.nextInt();
        scanner.nextLine();
        this.createMap(sizeOfMap);
        /**          * 1.2.Tworzenie miast*/
        System.out.println("Podaj ilosc miast");
        int numberOfCities = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCities; i++)
        {
            String randomName = this.randomize.randomizeName();
            int randomPrice = this.randomize.randomPrice();
            int[] randomPosition = this.randomize.posofCity(this.Mapa);
            this.createCity(randomName, randomPrice, randomPosition);
        }
        /**          * 1.3.Tworzenie nacji*/
        System.out.println("Podaj ilosc nacji: ");
        int numberOfNations = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj poczatkowy skarbiec nacji");
        int randomTresure = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfNations; i++)
        {
            String randomName = this.randomize.nationName();
            this.createNation(randomName, randomTresure);
        }
        /**          * 1.4.Tworzenie statków*/
        Iterator nationsIterator = this.Mapa.getNationsIterator();
        System.out.println("Podaj ilosc statkow");
        int randomNumberOfWarships = (int) scanner.nextInt();
        int randomNumberOfTradeShips = (int) randomNumberOfWarships/ 2;
        scanner.nextLine();
        int nr = 1;
        while (nationsIterator.hasNext()) {
            Nation nation = (Nation) nationsIterator.next();
            for (int i = 0; i < randomNumberOfTradeShips; i++) {

                int attack = this.randomize.randomAttack();
                int capacity = this.randomize.randomCapacity();
                int speed = this.randomize.randomSpeed();
                String country = nation.getName();
                this.createTradeShip(nation, attack, capacity, speed, country, this.Mapa, nr);
                nr++;
            }
            for (int i = 0; i < randomNumberOfWarships; i++) {

                int attack = this.randomize.randomAttack();
                int capacity = this.randomize.randomCapacity();
                int speed = this.randomize.randomSpeed();
                String country = nation.getName();
                this.createWarship(nation, attack, capacity, speed, country, this.Mapa, nr);
                nr++;
            }
        }

        try {
            Results.beggingOfSimulation();
        } catch (IOException e) {
            System.out.println("ASDF" + e);
        }

        /** Faza 2-Symulacja:*/
        System.out.println("Podaj czas symulacji");
        int timeOfSimulation = scanner.nextInt();
        try{
            Results.printResults(this.Mapa,0);}
        catch (IOException e){System.out.println("Error"+e);}

        for (int i = 0; i < timeOfSimulation; i++)
        {
            System.out.println("Tick "+ i);
            Iterator nationsiterator = this.Mapa.getNationsIterator();
            /** Każdy z warunków sprawdzany jest na każdym ze statków.*/
            while (nationsiterator.hasNext())
            {
                Nation nation = (Nation) nationsiterator.next();
                Iterator fleetIterator = nation.getFleet().getFleetIterator();
                while (fleetIterator.hasNext())
                {
                    IShip ship = (Aship) fleetIterator.next();
                    //System.out.println(ship.getNr());
                    /** 2.1 Sprawdzenie czy statek ma trasę,jeśli nie nadanie mu trasy.*/
                    boolean trasa=ship.hasRoute();
                    if (!trasa)
                    {
                        ship.AddRoute(this.randomize.createRoute(this.Mapa));
                        ship.move();
                        //System.out.println("Added route");
                    }
                    /**          * 2.2 Sprawdzenie czy statek jest w mieście.*/
                    if(ship.inCity())
                    {   ICity city = Mapa.findCity(ship.getPosition());
                        nation.earnGold(ship.getInventory()*city.getProductPrice());
                        ship.deleteRoute();
                        //System.out.println("Ship in city");
                    }
                    /**         * 2.3 Sprawdzenie czy statek jest w walce z innym.*/
                    //TODO
                    /**          * 2.4 Ruch statku jeśli żaden z powyższych warunków nie został spełniony.*/
                    ship.move();
                }
            }




            /**          * Co określoną ilość ticków do pliku zapisywany jest stan skarbca każdej z nacji.*/
            if(i%3000==0)
            {   try{
                Results.printResults(this.Mapa,i);}
                catch (IOException e){System.out.println("Error"+e);}
            }


        }
        /** * Faza 3-Podsumowanie:
         *          * Do pliku drukowane są końcowe wyniki symulacji.*/
        try{
            Results.printResults(this.Mapa,timeOfSimulation);}
        catch (IOException e){System.out.println("Error"+e);}
    }
    /**Metoda która uruchamia symulację z wybieralnymi parametrami*/
    private void runRandomSimulation()
    {
        /**Symulacja ze wszystkimi parametrami losowymi które są tworzone przez klasę {@link Randomize}.
         * * Faza 1-Tworzenie obiektów symulacji:
         *          * 1.1.Tworzenie mapy
         */
        int sizeOfMap = this.randomize.randomizeMapSize();
        this.createMap(sizeOfMap);
        /**          * 1.2.Tworzenie miast*/
        int numberOfCities = this.randomize.randomNumberOfCities();
        for (int i = 0; i < numberOfCities; i++)
        {
            String randomName = this.randomize.randomizeName();
            int randomPrice = this.randomize.randomPrice();
            int[] randomPosition = this.randomize.posofCity(this.Mapa);
            this.createCity(randomName, randomPrice, randomPosition);
        }
        /**          * 1.3.Tworzenie nacji*/
        int numberOfNations = this.randomize.randomNumberOfNations();
        int randomTresure = this.randomize.randomizeTresure();
        for (int i = 0; i < numberOfNations; i++)
        {
            String randomName = this.randomize.nationName();
            this.createNation(randomName, randomTresure);
        }
        /**          * 1.4.Tworzenie statków*/
        Iterator nationsIterator = this.Mapa.getNationsIterator();
        int randomNumberOfWarships = (int) this.randomize.randomNumberOfShips() / 2;
        int randomNumberOfTradeShips = (int) this.randomize.randomNumberOfShips() / 2;
        int nr = 1;
        while (nationsIterator.hasNext()) {
            Nation nation = (Nation) nationsIterator.next();
            for (int i = 0; i < randomNumberOfTradeShips; i++) {

                int attack = this.randomize.randomAttack();
                int capacity = this.randomize.randomCapacity();
                int speed = this.randomize.randomSpeed();
                String country = nation.getName();
                this.createTradeShip(nation, attack, capacity, speed, country, this.Mapa, nr);
                nr++;
            }
            for (int i = 0; i < randomNumberOfWarships; i++) {

                int attack = this.randomize.randomAttack();
                int capacity = this.randomize.randomCapacity();
                int speed = this.randomize.randomSpeed();
                String country = nation.getName();
                this.createWarship(nation, attack, capacity, speed, country, this.Mapa, nr);
                nr++;
            }
        }

        try {
            Results.beggingOfSimulation();
        } catch (IOException e) {
            System.out.println("ASDF" + e);
        }

        /** Faza 2-Symulacja:*/
        int timeOfSimulation = randomize.randomTime();
        try{
            Results.printResults(this.Mapa,0);}
        catch (IOException e){System.out.println("Error"+e);}

        for (int i = 0; i < timeOfSimulation; i++)
        {
            System.out.println("Tick "+ i);
            Iterator nationsiterator = this.Mapa.getNationsIterator();
            /** Każdy z warunków sprawdzany jest na każdym ze statków.*/
            while (nationsiterator.hasNext())
            {
                Nation nation = (Nation) nationsiterator.next();
                Iterator fleetIterator = nation.getFleet().getFleetIterator();
                while (fleetIterator.hasNext())
                {
                    IShip ship = (Aship) fleetIterator.next();
                    //System.out.println(ship.getNr());
                    /** 2.1 Sprawdzenie czy statek ma trasę,jeśli nie nadanie mu trasy.*/
                    boolean trasa=ship.hasRoute();
                    if (!trasa)
                    {
                        ship.AddRoute(this.randomize.createRoute(this.Mapa));
                        ship.move();
                        //System.out.println("Added route");
                    }
                    /**          * 2.2 Sprawdzenie czy statek jest w mieście.*/
                    if(ship.inCity())
                    {   ICity city = Mapa.findCity(ship.getPosition());
                        nation.earnGold(ship.getInventory()*city.getProductPrice());
                        ship.deleteRoute();
                        //System.out.println("Ship in city");
                    }
                    /**         * 2.3 Sprawdzenie czy statek jest w walce z innym.*/
                    //TODO
                    /**          * 2.4 Ruch statku jeśli żaden z powyższych warunków nie został spełniony.*/
                    ship.move();
                }
            }




            /**          * Co określoną ilość ticków do pliku zapisywany jest stan skarbca każdej z nacji.*/
            if(i%3000==0)
            {   try{
                Results.printResults(this.Mapa,i);}
            catch (IOException e){System.out.println("Error"+e);}
            }


        }
        /** * Faza 3-Podsumowanie:
         *          * Do pliku drukowane są końcowe wyniki symulacji.*/
        try{
            Results.printResults(this.Mapa,timeOfSimulation);}
        catch (IOException e){System.out.println("Error"+e);}
    }
}
