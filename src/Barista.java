public interface Barista {

    //prepare() method is an abstraction of preparing different drinks
    void prepare(Machine M);

    //Getters that allows get field of objects of classes that extended from Drinks superclass.
    double getPrice();
    String getName();
}
