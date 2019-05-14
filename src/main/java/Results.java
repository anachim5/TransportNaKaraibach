import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Results
{
public static void printResults(Map Mapa,int time) throws IOException
    {
        String report="Result for tick: "+time;
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true));
        writer.write(report);
        writer.newLine();
        while(Mapa.getNationsIterator().hasNext())
        {
             Nation nation= (Nation)Mapa.getNationsIterator().next();
             String strToWrite=nation.getName()+String.valueOf(nation.getTresure());
             writer.write(strToWrite);
             writer.newLine();
        }
        writer.close();
    }
}
