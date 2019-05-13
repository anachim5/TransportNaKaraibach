import java.util.ArrayList;

//Klasa definiująca mapę na której poruszają się statki
public class Map
{
    private final int[] size;
    private ArrayList<City> cities;
    private ArrayList<Nation> nations;


    //Konstruktor
    public Map(int[] rozmiar)
    {
        this.size=rozmiar;
        this.cities= new ArrayList<>();
        this.nations=new ArrayList<>();

    }
    //Dodawanie miast
    public void AddCity(City Miasto)
    {
       this.cities.add(Miasto);
    }
    //dodawanie nacji
    public void AddNation(Nation nacja)
    {
       this.nations.add(nacja);
    }
    //metoda która udostępnia poza klasę rozmiar mapy
    public int getSize()
    {
        return this.size[0];
    }
    //metoda która udostępnia nacje
    public Nation getNation(int nrNation)
    {
        return this.nations.get(nrNation);
    }
}
