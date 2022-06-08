public class Tea extends Drinks{

    protected double bTea;
    protected double gTea;
    protected double water;
    private final double price;

    protected int waterT;

    public String name;

    public Tea(String name, double water, int waterT, double price) {
        this.price = price;
        this.water = water;
        this.name = name;
        this.waterT = waterT;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName(){
        return this.name;
    }

}
