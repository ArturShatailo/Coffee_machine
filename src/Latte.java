public class Latte extends Coffee{

    public Latte(double coffee, double milk, double water, int waterT, int milkT, int pressure, double price) {
        super("Latte", coffee, water, waterT, pressure, price);
        this.milk = milk;
        this.milkT = milkT;
    }

    @Override
    public void prepare(Machine M) {
        milk = M.whiskMilk(milk, milkT);
        water = M.boilWater(water, waterT);
        M.makeEspresso(coffee, water);
        M.addMilk(milk);
    }

}
