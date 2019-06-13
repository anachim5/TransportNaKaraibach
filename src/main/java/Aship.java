/**Klasa abstrakcyjna definiująca statek.
 * Parametry statku to:
 *-atak,
 *-pojemność
 *-szybkośc poruszania
 *-numer
 * Statek ma swoją pozycję oraz trasę, które służa do jego poruszania.
 * Ma on również ładunek który sprzedawany jest w mieście.
 * Każdy ze statków przynależy do nacji
 */
public  abstract class Aship implements IShip
{
    private final int attack;
    private final int capacity;
    private final int speed;
    private int[] route;
    private int[] position;
    private int distance;
    private final String country;
    private final int Nr;
    private int inventory;
    /**Konstruktor statku
     * @param attack atak statku
     * @param capacity pojemnosc statku
     * @param speed predkosc statku
     * @param country nacja do której należy statek
     * @param mapa mapa na której znajduje sie statek
     * @param Nr numer statku*/
    public Aship(int attack,int capacity,int speed,String country,IMap mapa,int Nr)
    {
        /**
        *Tworzenie statku
        *Pola są statyczne ponieważ raz utworzony statek nie może mieć zmienionych już swoich statystyk
        *i nie może zmienić państwa dla którego pływa
        */
        this.attack=attack;
        this.capacity=capacity;
        this.speed=speed;
        this.country=country;
        this.position=IRandomize.positionOfCity(mapa);
        this.Nr=Nr;
        this.route=null;

    }
    /**Metoda pozwalająca na dodanie trasy,przy każdym dodaniu trasy jako że statek jest w mieście uzupełniany jest ekwipunek*/
    public void AddRoute(int[] route)
    {
        this.route=route;
        this.inventory=this.capacity;
        this.calculateDistance();
    }
    /**Metoda, która udostępnia cel statku*/
    public int[] getRoute()
    {
        return this.route;
    }
    /**Metoda, która usuwa drogę oraz czyści ekwipunek*/
    public void deleteRoute()
    {
        this.route = null;
        this.inventory = 0;
    }
    /**metoda która uzyskuje pozycję statyku w danym ticku*/
    public int[] getPosition(){ return this.position;    }
    /**metoda która ustala pozycję statku*/
    public void setPosition(int[]position){this.position=position;}
    /**metoda która udostępnia prędkość statku*/
    public int getSpeed(){return this.speed;}
    /**metoda która udostępnia atak*/
    public int getAttack(){return this.attack;}
    /**metoda która udostępnia pojemność statku*/
    public int getCapacity() { return this.capacity;}
    /**metoda która zeruje ekwipunek statku*/
    public void resetInventory(){this.inventory=0;}
    /**Metoda która zwraca nację do której należy statek*/
    public String getCountry() { return country;}
    /**Metoda która zwraca numer statku*/
    public int getNr() {return Nr; }
    /**Metoda która zwraca ładunek statku*/
    public int getInventory() { return inventory; }
    /**Metoda która wyznacza dystans jaki musi pokonać statek*/
    private void calculateDistance()
    {
        try
        {
            int x = (this.route[0] - this.position[0]) * (this.route[0] - this.position[0]);
            int y = (this.route[1] - this.position[1]) * (this.route[1] - this.position[1]);
            this.distance = (int) Math.sqrt(x + y);
        }
        catch (NullPointerException e)
        {
            this.distance=100;
        }
    }

    /**Metoda która sprawdza czy statek ma trasę*/
    public boolean hasRoute()
    {
        if(this.route!=null)
        {
            return true;
        }
        else
        {
        return false;
        }

    }
    /**Metoda która porusza statek*/
    public void move()
    {
        this.distance=this.distance-this.speed;
        if(this.distance<=0)
        {
        this.position=this.route;
        }
    }
    /**Metoda która sprawdza czy statek jest w mieście*/
    public boolean inCity()
    {
        if(this.position==this.route)
        {
            return true;
        }
        else return false;
    }
}
