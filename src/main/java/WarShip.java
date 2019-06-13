import java.util.Iterator;

/**Klasa definiująca statki wojenne*/
public class WarShip extends Aship
{
    public WarShip(int attack,int capacity,int speed,String country,IMap mapa,int Nr)
    {
    super(attack,capacity,speed,country,mapa,Nr);
    }
    /**Metoda która determinuję sposób w jaki statek prowadzi walkę,statki bojowe zyskują ekwipunek  przeciwnika jeśli wejdą z potyczkę i wygrają ,
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
                    if(statek.getCapacity()<this.getAttack())
                    {
                        this.addInventory(statek.getInventory());
                    }
                }

            }
        }
    }
}
