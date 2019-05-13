public class City
{
    private final String name;
    private final int price;
    private final int[] position;
    public City(String name,int price,int[] position)
    {
        this.name=name;
        this.price=price;
        this.position=position;
    }
    public int[] getPosition()
    {
        return this.position;
    }
    public int getProductPrice()
    {
        return this.price;
    }

}
