//Klasa opisują statek, podstawowy obiekt który się porusza po mapie
//Wchodzi on w interakcje z innymi statkami
public class Ship extends AShip
{
    private final int attack;
    private final int capacity;
    private final int speed;
    private int[] route;
    private int[] position;
    private final String country;
    private int inventory;
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
        this.inventory=this.capacity;
    }
    public int[] getRoute()
    {
        return this.route;
    }
    public void deleteRoute(){
        this.route=null;
        this.inventory=0;
    }
    public int[] getPosition(){ return this.position;    }
    public void setPosition(int[]position){this.position=position;}
    public int getSpeed(){return this.speed;}
    public int getAttack(){return this.attack;}
    public int getCapacity() { return this.capacity;}
    protected void resetInventory(){this.inventory=0;}

}
