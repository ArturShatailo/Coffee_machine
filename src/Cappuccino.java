public class Cappuccino extends Coffee{

    public Cappuccino(double coffee, double milk, double water, int waterT, int milkT, int pressure, double price) {
        super("Cappuccino", coffee, water, waterT, pressure, price);
        this.milk = milk;
        this.milkT = milkT;
    }

    @Override
    public void prepare(Machine M) {
        water = M.boilWater(water, waterT);
        M.makeEspresso(coffee, water);
        milk = M.whiskMilk(milk, milkT);
        M.addMilk(milk);
    }

}
