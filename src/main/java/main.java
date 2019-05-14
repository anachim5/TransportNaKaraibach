import java.io.IOException;

public class main
{
    //Główna metoda w której są wykonywane akcje w całej symulacji
    public static void main(String[] args) throws IOException
    {
        //1.Tworzenie mapy
        Map Mapa = Simulation.createMap(Randomize.randomizeMapSize());
        //2.Dodawanie miast
        for (int i = 0; i < Randomize.randomNumberOfCities(); i++)
        {
            Mapa.AddCity(Simulation.createCity(Mapa));
        }
        //3.Tworzenie nacji
        for (int i=0;i<Randomize.randomNumberOfNations();i++)
        {
            Mapa.AddNation(Simulation.createNation());
            //3.1 Tworzenie flot dla każdej z nacji
            Mapa.getNation(i).createFleet();
            //3.2 Tworzenie statków dla nacji
            for (int j=0;j<Randomize.randomNumberOfShips();j++)
            {
                Mapa.getNation(i).getFleet().addShip(Simulation.createShip(Mapa.getNation(i).getName()));
            }
        }
        //4.Symulacja
        for ( int time=0;time<Randomize.randomTime();time++)
        {   //4.0 Każdy statek
            while(Mapa.getNationsIterator().hasNext())
            {
                Object nacja=Mapa.getNationsIterator().next();
                Nation Nacja=(Nation)nacja;
                while(Nacja.getFleet().getFleetIterator().hasNext())
                {
                        Object sHip=Nacja.getFleet().getFleetIterator().next();
                        Ship ship=(Ship)sHip;
                    //4.1 Sprawdzanie czy statek ma trasę
                    if (!ShipIntegrations.hasRoute(ship)) {
                        ShipIntegrations.createRoute(ship,Mapa);
                        ShipIntegrations.move(ship);
                    }
                    //4.2 Sprawdzanie czy statek jest w miescie
                    if (ShipIntegrations.inCity(ship))
                    {
                        ShipIntegrations.sellProduct(ship,Mapa,Nacja);
                        ShipIntegrations.deleteRoute(ship);
                        continue;
                    }
                    //4.3 Sprawdzanie czy statek walczy
                    if (ShipIntegrations.inFight(ship,Mapa))
                    {
                        ShipIntegrations.Fight(ship,Mapa);

                    }
                    //4.4 Ruch statku
                    ShipIntegrations.move(ship);
                    //Wypisanie wyniku co 1000 ticków
                    if (time % 1000 == 0)
                    {
                        Results.printResults(Mapa, time);

                    }
                }
            }
        }
        //5.Wyniki
        Results.printResults(Mapa, 0);

    }
}
