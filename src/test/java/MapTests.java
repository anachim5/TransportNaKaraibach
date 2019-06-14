
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MapTests
{
Map TestowaMapa= new Map(666);
    @Test
    public void TestMapSize()
    {
    assertEquals("Mapa powinna zwracać odpowiednią wartość",TestowaMapa.getSize(),666);
    }
    @Test
    public void TestNations()
    {
        assertNotNull("Metoda powinna zwracać iterator nacji",TestowaMapa.getNationsIterator());
    }
}
