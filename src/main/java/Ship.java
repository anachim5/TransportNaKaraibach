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
    private final int Nr;
    private int inventory;
    public Ship(int attack,int capacity,int speed,String country,Map mapa,int Nr)
    {
        //Tworzenie statku
        //Pola są statyczne ponieważ raz utworzony statek nie może mieć zmienionych już swoich statystyk
        //i nie może zmienić państwa dla którego pływa
        this.attack=attack;
        this.capacity=capacity;
        this.speed=speed;
        this.country=country;
        this.position=Randomize.positionOfCity(mapa);
        this.Nr=Nr;

    }
    //Metoda pozwalająca na dodanie trasy
    public void AddRoute(int[] route)
    {
        this.route=route;
        this.inventory=this.capacity;
    }
    //metoda która udostępnia drogę
    public int[] getRoute()
    {
        return this.route;
    }
    //metoda która usuwa drogę oraz czyści ekwipunek
    public void deleteRoute(){
        this.route=null;
        this.inventory=0;
    }
    //metoda która uzyskuje pozycję statyku w danym ticku
    public int[] getPosition(){ return this.position;    }
    //metoda która ustala pozycję statku
    public void setPosition(int[]position){this.position=position;}
    //metoda która udostępnia prędkość statku
    public int getSpeed(){return this.speed;}
    //metoda która udostępnia atak
    public int getAttack(){return this.attack;}
    //metoda która udostępnia pojemność statku
    public int getCapacity() { return this.capacity;}
    //metoda która zeruje ekwipunek statku
    protected void resetInventory(){this.inventory=0;}

    public String getCountry() {
        return country;
    }

    public int getNr() {
        return Nr;
    }

    public int getInventory() {
        return inventory;
    }
}
