//Klasa opisują statek, podstawowy obiekt który się porusza po mapie
//Wchodzi on w interakcje z innymi statkami
public class Ship extends AShip
{
    private final int attack;
    private final int capacity;
    private final int speed;
    private int[] route;
    private final String country;
    public Ship(int attack,int capacity,int speed,String country)
    {
        //Tworzenie statku
        //Pola są statyczne ponieważ raz utworzony statek nie może mieć zmienionych już swoich statystyk
        //i nie może zmienić państwa dla którego pływa
        this.attack=attack;
        this.capacity=capacity;
        this.speed=speed;
        this.country=country;

    }
    //Metoda pozwalająca na dodanie trasy
    public void AddRoute(int[] route)
    {
        this.route=route;
    }
    public int[] getRoute()
    {
        return this.route;
    }
}
