import java.io.FileWriter;
import java.io.PrintWriter;

public class Results
{
public static void printResults(Map Mapa,int time)
    {   String filename="Wyniki_Tick_"+"time";
        FileWriter fw =new FileWriter(filename);
        PrintWriter pw = new PrintWriter(fw);
        while(Mapa.getNationsIterator().hasNext())
        {
            String report ="";
        }
        }
}
