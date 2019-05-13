
public class main
{
    //Główna metoda w której są wykonywane akcje w całej symulacji
    public static void main(String[] args)
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

            //4.1 Sprawdzanie czy statek ma trasę
            if (!ShipIntegrations.hasRoute(ship))
            {
                ShipIntegrations.createRoute(ship);
                ShipIntegrations.move(ship);
            }
            //4.2 Sprawdzanie czy statek jest w miescie
            if (ShipIntegrations.inCity(ship))
            {
                ShipIntegrations.sellProduct(ship);
                ShipIntegrations.resetRoute(ship);
                continue;
            }
            //4.3 Sprawdzanie czy statek walczy
            if(ShipIntegrations.inFight(ship))
            {
                ShipIntegrations.Fight(ship);

            }
            //4.4 Ruch statku
            ShipIntegrations.move(ship);
            //Wypisanie wyniku co
            if(time%1000==0)
            {
                Results.printResults(Mapa,time);

            }
        }
        //5.Wyniki
        Results.printResults(Mapa);
    }
}
