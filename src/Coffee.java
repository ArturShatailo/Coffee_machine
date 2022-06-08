public class Coffee extends Drinks{

    protected double milk;
    protected double water;
    protected double coffee;
    private final double price;

    protected int milkT;
    protected int waterT;
    protected int pressure;

    public String name;

    public Coffee(String name, double coffee, double water, int pressure, int waterT, double price) {
        this.coffee = coffee;
        this.water = water;
        this.price = price;
        this.name = name;
        this.pressure = pressure;
        this.waterT = waterT;
    }

    @Override
    public double getPrice(){
        return this.price;
    }

    @Override
    public String getName(){
        return this.name;
    }


}
