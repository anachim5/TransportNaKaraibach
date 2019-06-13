import java.util.Random;

/** Interfejs klasy odpowiedzialny za losowanie parametrów symulacji*/
public  interface IRandomize
{
    /**Metoda tworząca Losową wielkosc mapy
     * @return wielkosc mapy*/
     int randomizeMapSize();
    /**Metoda wybierajaca losowa nazwe miasta
     * @return nazwa miasta*/
      String randomizeName();
    /**metoda tworząca losową cene produktów w miescie
     * @return cena produktu w miescie*/
      int randomPrice();
    /**metoda tworząca losową ilosc miast
     * @return ilosc miast*/
      int randomNumberOfCities();
    /**metoda tworzaca losowa ilosc nacji
     * @return ilosc nacji*/
      int randomNumberOfNations();
    /**metoda wybierajaca losowa nazwe nacji
     * @return nazwa nacji*/
      String nationName();
    /**metoda generujaca losowy poczatkowy skarb nacji
     * @return ilosc zlota w skarbcu*/
       int randomizeTresure();
    /**metoda tworzaca losowa wartosc ataku statku
     * @return atak statku*/
      int randomAttack();
    /**metoda tworzaca losowa predkosc statku
     * @return predkosc statku*/
      int randomSpeed();
    /**metoda tworząca losową pojemnośc statku
     * @return pojemnosc statku*/
      int randomCapacity();
    /**metoda tworząca losową ilość statków we flocie
     * @return ilosc statków w flocie*/
      int randomNumberOfShips();
    /**metoda tworząca losową ilość ticków symulacji*
     * @return czas symulacji
     */

      int randomTime();
    /**metoda tworząca losową trasę do miasta na mapie
     * @param mapa mapa na której jest symulacja
     * @return pozycja miasta które znajduje sie na mapie*/
      int[] createRoute(IMap mapa);
    /**Metoda wybierajaca losowa pozycje miasta na mapie
     * @param mapa mapa na której dzieje sie symulacja
     * @return pozycja miasta na mapie*/
      static int[] positionOfCity(IMap mapa)
      {
          Random gen = new Random();
          int x=gen.nextInt(mapa.getSize());
          int y=gen.nextInt(mapa.getSize());
          int d[]={x,y};
          return d;
      }
    /**Metoda wybierajaca losowa pozycje miasta na mapie
     * @param mapa mapa na której odbywa się symulacja
     * @return pozycja miasta*/
      int[] posofCity(IMap mapa);
}
