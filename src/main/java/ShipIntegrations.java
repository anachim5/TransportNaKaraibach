

public class ShipIntegrations {
    public static boolean hasRoute(Ship statek) {
        if (statek.getRoute() != null)
            return true;
        else
            return false;
    }

    public static void createRoute(Ship statek, Map mapa) {
        int[] route = Randomize.createRoute(mapa);
        statek.AddRoute(route);
    }

    public static void deleteRoute(Ship statek) {
        statek.deleteRoute();
    }

    public static void move(Ship statek){
        if(statek.getRoute()!=null)
        {
            int[] position = statek.getPosition();
            int[] route = statek.getRoute();
            boolean drogax = route[0] > position[0];
            boolean drogay = route[1] > position[1];

            //jezeli statek porusza sie kierunku ujemnym predkosc(trase na jeden tick)odejmujemy
            //wartość prędkosci do pozycji,a jeżeli w dodatnim dodajemy
            if (drogax  && drogay ) {
                int[] movement = {position[0] + statek.getSpeed(), position[1] + statek.getSpeed()};
                statek.setPosition(movement);
            }
            if (drogax  && !drogay ) {
                int[] movement = {position[0] + statek.getSpeed(), position[1] - statek.getSpeed()};
                statek.setPosition(movement);
            }
            if (!drogax  && drogay) {
                int[] movement = {position[0] - statek.getSpeed(), position[1] + statek.getSpeed()};
                statek.setPosition(movement);
            }
            if (!drogax  && !drogay ) {
                int[] movement = {position[0] - statek.getSpeed(), position[1] - statek.getSpeed()};
                statek.setPosition(movement);
            }
        }
    }

    //metoda sprawdzajaca czy statek znajduje sie w ktoryms miast na mapie
    public static boolean inCity(Ship ship) {   //jezeli pozycja statku jest miejscem docelowym to znajduje sie on w miescie
        if (ship.getPosition() == ship.getRoute()) {
            return true;
        } else {
            return false;
        }
    }

    //metoda ktora sprzedaje zawartosc ladowni statku po cenie w miescie
    public static void sellProduct(Ship ship, Map map, Nation nation) {   //znajdujemy miasto w ktorym jest statek
        City goalCity = map.findCity(ship.getPosition());
        //obliczamy dochod ze sprzedazy produktow na statku
        int amount = ship.getCapacity() * goalCity.getProductPrice();
        // dodajemy zloto to skarbca nacji do ktorej nalezy statek
        nation.earnGold(amount);
    }

    public static boolean inFight(Ship ship, Map mapa) {
        if (findNearestShip(ship, mapa) != null) {
            return true;
        } else {
            return false;
        }
    }

    private static Ship findNearestShip(Ship ship, Map mapa) {
        while (mapa.getNationsIterator().hasNext()) {
            Nation nation = (Nation) mapa.getNationsIterator().next();
            while (nation.getFleet().getFleetIterator().hasNext()) {
                Ship statek = (Ship) nation.getFleet().getFleetIterator().next();
                if (statek.getPosition() == ship.getPosition())
                    return statek;
            }
        }
        return null;
    }

    public static void Fight(Ship ship, Map mapa) {
        Ship foundShip = findNearestShip(ship, mapa);
        if (foundShip != null) {
            if (foundShip.getAttack() > ship.getAttack()) {
                ship.resetInventory();
            }
            if (foundShip.getAttack() < ship.getAttack()) {
                foundShip.resetInventory();
            }
            if (foundShip.getAttack() == ship.getAttack()) {

            }
        }
    }
}