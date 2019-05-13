

public class ShipIntegrations
{
public static boolean hasRoute(Ship statek)
    {
        if (statek.getRoute()!=null)
            return true;
        else
            return false;
    }
public static void createRoute(Ship statek,Map mapa)
    {
    int[]route = Randomize.createRoute(mapa);
     statek.AddRoute(route);
    }
public static void deleteRoute(Ship statek)
    {
        statek.deleteRoute();
    }
public static void move(Ship statek)
    {
        int[]position=statek.getPosition();
        int[]route =statek.getRoute();
        int[]movement;
           //jezeli statek porusza sie kierunku ujemnym predkosc(trase na jeden tick)odejmujemy
            //wartość prędkosci do pozycji,a jeżeli w dodatnim dodajemy
        if(route[0]-position[0]>0 && route[1]-position[1]>0)
        {
            movement[0]=position[0]+statek.getSpeed();
            movement[1]=position[1]+statek.getSpeed();
        }
        if(route[0]-position[0]>0 && route[1]-position[1]<0)
        {
            movement[0]=position[0]+statek.getSpeed();
            movement[1]=position[1]-statek.getSpeed();
        }
        if(route[0]-position[0]<0 && route[1]-position[1]>0)
        {
            movement[0]=position[0]-statek.getSpeed();
            movement[1]=position[1]+statek.getSpeed();
        }
        if(route[0]-position[0]<0 && route[1]-position[1]<0)
        {
            movement[0]=position[0]-statek.getSpeed();
            movement[1]=position[1]-statek.getSpeed();
        }
        statek.setPosition(movement);
    }
//metoda sprawdzajaca czy statek znajduje sie w ktoryms miast na mapie
public static boolean inCity(Ship ship)
    {   //jezeli pozycja statku jest miejscem docelowym to znajduje sie on w miescie
        if(ship.getPosition()==ship.getRoute())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
//metoda ktora sprzedaje zawartosc ladowni statku po cenie w miescie
public static void sellProduct(Ship ship,Map map,Nation nation)
    {   //znajdujemy miasto w ktorym jest statek
        City goalCity= map.findCity(ship.getPosition());
        //obliczamy dochod ze sprzedazy produktow na statku
        int amount=ship.getCapacity()*goalCity.getProductPrice();
        // dodajemy zloto to skarbca nacji do ktorej nalezy statek
        nation.earnGold(amount);
    }
public static boolean inFight(Ship ship,Map mapa)
    {
        if()
    }
private static Ship findNearestShip(Ship ship,Map mapa)
    {

    }
}
