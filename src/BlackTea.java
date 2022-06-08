public class BlackTea extends Tea{

    public BlackTea(double tea, double water, int waterT, double price) {
        super("Black tea", water, waterT, price);
        this.bTea = tea;
    }

    @Override
    public void prepare(Machine M) {
        M.addBlackTea(bTea);
        water = M.boilWater(water, waterT);
        M.addWater(water);
    }

}
