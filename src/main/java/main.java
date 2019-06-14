import java.util.Scanner;

/**
 * Symulacja transportu surowców przez statki na morzu.
 * Każdy ze statków należy do danej nacji i poruszając się między miastami,
 * generuje zyski dla swojej nacji.
 * Klasa {@link IMap} definiuje mapę.Znajdują się na niej nacje {@link INation}.
 * Do nacji należą statki, których parametry i zachowania definiowane są przez {@link IShip}.
 * Wyniki symulacji są udostępniane do pliku przez {@link IResults}.
 * Cały proces symulacji oraz obiekty do niej potrzebnej definiuje{@link Simulation}.
 *
 */
public class main
{
public static void main(String[] args)
{
boolean random=false;
ISeed seed=new Seed();
System.out.println("Witaj w symulacji transportu na karaibach!");
System.out.println("Czy chcesz aby byla ona w pelni losowa?");
System.out.println("(1)Symulacja w pelni losowa");
System.out.println("(2)Symulacja z mozliwymi do wyboru parametrami");
    Scanner scanner = new Scanner(System.in);
    int odp = scanner.nextInt();
    if(odp==1)
    {
        random=true;
    }
    if(odp==2)
    {
        random=false;

    }
System.out.println("Podaj seed");
seed.setSeed(scanner.nextLong());



Simulation sim=new Simulation(seed);
sim.runSimulation(random);
System.out.println("Simulation finished,Thank you next");
}
}
/**@author Kacper Jaskulski 2019*/