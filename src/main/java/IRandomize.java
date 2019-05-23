/** Interfejs klasy odpowiedzialny za losowanie parametrów symulacji*/
public  interface IRandomize
{
    /**Metoda tworząca Losową wielkosc mapy*/
     int randomizeMapSize();
    /**Metoda wybierajaca losowa nazwe miasta*/
      String randomizeName();
    /**metoda tworząca losową cene produktów w miescie*/
      int randomPrice();
    /**metoda tworząca losową ilosc miast*/
      int randomNumberOfCities();
    /**metoda tworzaca losowa ilosc nacji*/
      int randomNumberOfNations();
    /**metoda wybierajaca losowa nazwe nacji*/
      String nationName();
    /**metoda generujaca losowy poczatkowy skarb nacji*/
       int randomizeTresure();
    /**metoda tworzaca losowa wartosc ataku statku*/
      int randomAttack();
    /**metoda tworzaca losowa predkosc statku*/
      int randomSpeed();
    /**metoda tworząca losową pojemnośc statku*/
      int randomCapacity();
    /**metoda tworząca losową ilość statków we flocie*/
      int randomNumberOfShips();
    /**metoda tworząca losową ilość ticków symulacji*/
      int randomTime();
    /**metoda tworząca losową trasę do miasta na mapie*/
      int[] createRoute(Map mapa);
    /**Metoda wybierajaca losowa pozycje miasta na mapie*/
      int[] positionOfCity(Map mapa);
}
