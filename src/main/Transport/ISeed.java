/**Interfejs klasy{@link Seed} zawierający metody pozwalające na ustawienie {@link #setSeed}
 * oraz uzyskanie ziarna generatora losowego{@link #getSeed}*/
public interface ISeed
{
    /**Metoda zwracająca ziatno generatora losowego*/
    long getSeed();
    /**Metoda pozwalająca na ustawienie ziarna generatora losowego*/
    void setSeed(long seed);
}
