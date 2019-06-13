import java.util.Iterator;

/**Klasa definiująca statki handlowe*/
public class TradeShip extends Aship {
    public TradeShip(int attack,int capacity,int speed,String country,IMap mapa,int Nr) {
      super(attack,capacity,speed,country,mapa,Nr);
    }

    /**Metoda która determinuję sposób w jaki statek prowadzi walkę,statki kupieckie tracą swój ekwipunek jeśli wejdą z potyczkę i przegrają,
     * nie zależnie czy jest to statek bojowy czy kupiecki.
     * @param mapa mapa na której dzieje się symulacja
     */
    public void fight(IMap mapa)
    {
        Iterator nacje=mapa.getNationsIterator();
        while( nacje.hasNext())
        {
            Nation nacja= (Nation)nacje.next();
            Iterator statki=nacja.getFleet().getFleetIterator();
            while(statki.hasNext())
            {
                Aship statek= (Aship)statki.next();
                if(statek.getPosition()==this.getPosition())
                {
                    if(statek.getCapacity()>this.getAttack())
                    {
                        this.resetInventory();
                    }
                }

            }
        }
    }
}
