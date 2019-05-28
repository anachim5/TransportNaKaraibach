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
ISeed seed=new Seed();
seed.setSeed(34356);
Simulation sim=new Simulation(seed);
sim.runSimulation(true);
System.out.println("Simulation finished,Thank you next");
}
}
/**@author Kacper Jaskulski 2019*/