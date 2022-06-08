public class GreenTea extends Tea{

    public GreenTea(double tea, double water, int waterT, double price) {
        super("Green tea", water, waterT, price);
        this.gTea = tea;
    }

    @Override
    public void prepare(Machine M) {
        M.addGreenTea(bTea);
        water = M.boilWater(water, waterT);
        M.addWater(water);
    }

}
