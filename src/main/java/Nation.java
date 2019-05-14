public class Nation
{
    private final String name;
    private int tresure;
    private Fleet fleet;
    //Konstruktor
    public Nation(String name,int tresure)
    {
        this.name=name;
        this.tresure=tresure;
        this.fleet= new Fleet();
    }
    //Tworzenie floty
    public void createFleet()
    {
        this.fleet=new Fleet();
    }
    //metoda udostępniająca flotę
    public Fleet getFleet()
    {
        return this.fleet;
    }
    public String getName()
    {
        return this.name;
    }
    public void earnGold(int amount)
    {
        this.tresure+=amount;
    }
    public int getTresure()
    {
        return this.tresure;
    }
}
