public class Americano extends Coffee{

    public Americano(double coffee, double water, int waterT, int pressure, double price) {
        super("Americano", coffee, water, pressure, waterT, price);
    }

    @Override
    public void prepare(Machine M) {
        water = M.boilWater(water, waterT);
        M.makeEspresso(coffee, water/3);
        M.addWater(water);
    }

}
