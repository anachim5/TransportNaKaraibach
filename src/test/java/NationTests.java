import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


public class NationTests
{
  Nation TestNation = new Nation("Testowa nacja",4567890);
  @Test
  public void TestName()
  {
    assertEquals("Nazwa nacji powinna być zwracana prawdziwie",TestNation.getName(),"Testowa nacja");
  }
  @Test
  public void TestTresure()
  {
    assertEquals("Wartośc skarbca powinna byc zwraca prawdziwie",TestNation.getTresure(),4567890);
  }
  @Test
  public void TestReturnedFleet()
  {
    TestNation.createFleet();
    assertNotNull("Metoda powinna zwracać obiekt",TestNation.getFleet());
  }
}
