import java.io.IOException;
import java.util.Iterator;

public class main
{
    //Główna metoda w której są wykonywane akcje w całej symulacji
    public static void main(String[] args) throws IOException
    {
        //1.Tworzenie mapy
        Map Mapa = Simulation.createMap(Randomize.randomizeMapSize());
        System.out.println("Utworzono mape");
        //2.Dodawanie miast
        for (int i = 0; i < Randomize.randomNumberOfCities(); i++)
        {
            Mapa.AddCity(Simulation.createCity(Mapa));
            System.out.println("Utworzono miasto#"+i);
        }
        //3.Tworzenie nacji
        for (int i=1;i<Randomize.randomNumberOfNations()+1;i++)
        {
            Mapa.AddNation(Simulation.createNation());
            System.out.println("Utworzono nacje#"+i);
            //3.1 Tworzenie flot dla każdej z nacji
            Mapa.getNation(i-1).createFleet();
            System.out.println("Utworzono flote#"+i);
            //3.2 Tworzenie statków dla nacji
            for (int j=1;j<Randomize.randomNumberOfShips()+1;j++)
            {
                Mapa.getNation(i-1).getFleet().addShip(Simulation.createShip(Mapa.getNation(i-1).getName(),Mapa,i*j));
                System.out.println("Utworzono statek dla nacji #"+i+"o numerze: "+j);
            }
        }
        //3.3 Utworzone nacje
        Results.showCreatedNations(Mapa);
        //4.Symulacja
        //4.1 Wylosowanie czasu symulacji
        int timeOfSim=Randomize.randomTime();
        System.out.println("Czas symulacji: "+timeOfSim);
        //Wypisanie poczatkowych warunkow symulacji
        Results.beggingOfSimulation();
        Results.printResults(Mapa,0);
        for ( int time=0;time<timeOfSim;time++)
        {
            //Uzyskanie Nacji z mapy
            Iterator nationIterator=Mapa.getNationsIterator();
            while(nationIterator.hasNext())
            {
                //utworzenie obiektów nacji z iteratora
                Nation Nacja= (Nation) nationIterator.next();
                //uzyskanie statków
                Iterator fleetIterator=Nacja.getFleet().getFleetIterator();
                while(fleetIterator.hasNext())
                {
                    //obiekt statków
                    Ship ship=(Ship)fleetIterator.next();
                    System.out.println("Tick nr: "+time+"Dla statku "+ship.getNr());
                    //4.1 Sprawdzanie czy statek ma trasę
                    if (!ShipIntegrations.hasRoute(ship)) {
                        ShipIntegrations.createRoute(ship,Mapa);
                        //ShipIntegrations.move(ship);
                        System.out.println("Nadano statkowi droge");
                        //continue;
                    }
                    //4.2 Sprawdzanie czy statek jest w miescie
                    if (ShipIntegrations.inCity(ship))
                    {
                        ShipIntegrations.sellProduct(ship,Mapa,Nacja);
                        ShipIntegrations.deleteRoute(ship);
                        System.out.println("Statek jest w miescie");
                        //continue;

                    }
                    if (!ShipIntegrations.inCity(ship))System.out.println("Statek nie jest w miescie");
                    //4.3 Sprawdzanie czy statek walczy

                    //4.4 Ruch statku
                    System.out.println("Statek sie porusza");
                    ShipIntegrations.move(ship);
                    //System.out.println("Symulacja przeszla tick nr # "+ time);

                    //Wypisanie wyniku co 1000 ticków
                }
            }
        if(time%1000==0)
        {
            Results.printResults(Mapa,time);
        }
        }
        //5.Wyniki
        Results.printResults(Mapa, timeOfSim);

    }
}
