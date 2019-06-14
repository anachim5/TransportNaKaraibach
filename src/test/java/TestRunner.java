import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class TestRunner
{
    public static void main(String[] args)
    {
        Result resultNation = JUnitCore.runClasses(NationTests.class);
        Result resultMap = JUnitCore.runClasses(Map.class);
        Result resultShip = JUnitCore.runClasses(ShipTests.class);
        for (Failure failure : resultNation.getFailures())
        {
            System.out.println(failure.toString());
        }
        for (Failure failure : resultMap.getFailures())
        {
            System.out.println(failure.toString());
        }
        for (Failure failure : resultShip.getFailures())
        {
            System.out.println(failure.toString());
        }

    }
}