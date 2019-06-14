import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class ShipTests
{
IMap mapa= new Map(666);
Aship TestShip = new WarShip(30,30,30,"Polsa",this.mapa,69);
    @Test
    public void TestRoute()
    {
        assertFalse("Powinno zwracac falsz poniewaz statek nie ma nadanej drogi",TestShip.hasRoute());
        int[] trasa={12,34};
        TestShip.AddRoute(trasa);
        assertTrue("Powinno zwracac prawde poniewaz statek ma dodana trase",TestShip.hasRoute());
    }
}
