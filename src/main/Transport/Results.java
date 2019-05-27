import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;

public class Results implements IResults
{
    public void beggingOfSimulation() throws IOException
    {
        String report="Start of Simulation "+ LocalDateTime.now();
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true));
        writer.write(report);
        writer.newLine();
        writer.close();
    }
    public void printResults(Map Mapa,int time) throws IOException
    {
        System.out.println("Printing results for tick: "+ time);
        String report="Result for tick: "+time;
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true));
        writer.write(report);
        writer.newLine();
        String Table="Nacja   |   Zloto";
        writer.write(Table);
        writer.newLine();
        Iterator nationIterator=Mapa.getNationsIterator();
        while(nationIterator.hasNext())
        {
            Nation nation= (Nation)nationIterator.next();
            String strToWrite=nation.getName()+" |  "+String.valueOf(nation.getTresure());
            writer.write(strToWrite);
            writer.newLine();
        }
        writer.newLine();
        writer.close();
    }
}
