import java.io.IOException;

/**Interfejs klasy która zajmuje się analizą i udostępnianiem wyników symulacji
 * Metoda {@link #beggingOfSimulation()} odpowiada za wypisanie do pliku stanu początkowego symulacji oraz czasu jej rozpoczęcia.
 * Metoda {@link #printResults(IMap, int)} odpowiedialna jest za wypisywanie aktualnego stanu skarbca każdej z utworzonych nacji
 * w określonym przez parametr czasie.
 * */
public interface IResults
{
    /**Metoda opisująca początek symulacji
     * @throws IOException ze względu na użytą klasę do wypisywania wyników
     */
    void beggingOfSimulation() throws IOException;
    /**Metoda wypisująca stan skarbca w określonym czasie
     * @throws IOException ze względu na użytą klasę do wypisywania wyników
     * @param Mapa mapa na którrej dzieje się symulacja
     * @param time aktualny czas w symulacji dla którego mają być wypisane wyniki*/
    void printResults(IMap Mapa,int time) throws IOException;

}
