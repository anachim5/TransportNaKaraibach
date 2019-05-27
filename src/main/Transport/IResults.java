import java.io.IOException;

/**Interfejs klasy która zajmuje się analizą i udostępnianiem wyników symulacji
 * Metoda{@link #beggingOfSimulation()}odpowiada za wypisanie do pliku stanu początkowego symulacji oraz czasu jej rozpoczęcia.
 * Metoda{@link #printResults(Map, int)}odpowiedialna jest za wypisywanie aktualnego stanu skarbca każdej z utworzonych nacji
 * w określonym przez parametr czasie.
 * */
public interface IResults
{
    /**Metoda opisująca początek symulacji*/
    void beggingOfSimulation() throws IOException;
    /**Metoda wypisująca stan skarbca w określonym czasie*/
    void printResults(Map Mapa,int time) throws IOException;

}
