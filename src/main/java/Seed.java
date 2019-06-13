/** Klasa definiująca ziarno generatora losowego*/
public class Seed implements ISeed{
    /**Ziarno losowe*/
    private long Seed;
    public long getSeed(){return this.Seed;}
    public void setSeed(long seed){this.Seed=seed;}
}
