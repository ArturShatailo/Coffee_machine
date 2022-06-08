import java.util.ArrayList;
import java.util.HashMap;

public class Machine{

    private final HashMap<String, Double> ingredients = new HashMap<>();
    private final HashMap<String, Drinks> menu = new HashMap<>();
    private final ArrayList<Drinks> order = new ArrayList<>();
    private final ArrayList<String> errors = new ArrayList<>();
    private final ArrayList<Drinks> done = new ArrayList<>();

    //This method fills 'menu' collection with Drinks objects of different available options and their keys.
    public void start(){

        menu.put("Cappuccino", new Cappuccino(12.0, 75.0, 100.0, 90, 62, 9, 40.0));
        menu.put("Americano", new Americano(9.0, 180.0, 90, 12, 35.0));
        menu.put("Latte", new Latte(12.0, 180.0, 80.0, 91, 62, 12, 45.0));
        menu.put("Black tea", new BlackTea(20.0, 250.0, 95, 30.0));
        menu.put("Green tea", new GreenTea(20.0, 250.0, 80, 32.0));

    }

    //This method fills ingredients collection with all needed elements to full value.
    public void addIngredients() {

        ingredients.put("milk", 1000.0);
        ingredients.put("coffee", 500.0);
        ingredients.put("water", 2000.0);
        ingredients.put("sugar", 1000.0);
        ingredients.put("green tea", 500.0);
        ingredients.put("black tea", 500.0);

    }

    //In this method machine checks if there are any errors in collection, clear 'order', 'errors' and 'done' collections
    //from previous orders data. Then, starts UI with menu and all options to choose.
    public void callMenu(){
        ifError();
        clearSet();

        System.out.println("What do you want to drink? (input drink name + 'Enter' or double tap 'Enter' to exit)");
        menu.forEach((s, d) -> System.out.println(s+" price: "+d.getPrice()));
        serve();
    }

    //This method take user's orders, call 'prepareALl' method and then print total price, products that are done from 'done'
    //collection and prints all errors. Then, calls callMenu() method.
    private void serve() {
        boolean queue = true;
        while(queue){ queue = makeOrder(); }
        prepareAll();

        System.out.println("Total price: "+sumAll());

        done.forEach(d -> System.out.print(d.getName()+" "));

        System.out.println("\n");
        errors.forEach(System.out::println);
        System.out.println("\n");

        callMenu();
    }

    //previous order data cleaner.
    private void clearSet(){
        done.clear();
        order.clear();
        errors.clear();
    }

    //This method takes value from console input and calls addToOrder() method to collect Drinks objects
    //according to inputs in 'order' collection.
    private boolean makeOrder() {
        String c = Tech.GetInputStringFunction();
        if (menu.containsKey(c)){
            addToOrder(c);
            return true;
        }else {
            return false;
        }
    }

    //add Drinks objects from menu collection to order collection.
    private void addToOrder(String drink){
        order.add(menu.get(drink));
    }

    //This method calls prepare() method of each object from 'order' collection and checks if there are any errors in
    //'errors' collection. If they are absent, method adds object to 'done' collection.
    private void prepareAll() {
        //order.forEach(drinks -> drinks.prepare(this));

        for (Drinks d:order){
            d.prepare(this);
            checkMachine();
            if (errors.isEmpty()) done.add(d);
        }

    }

    //summing up all price fields of objects in 'done' collection.
    private double sumAll() {
        return done.stream().mapToDouble(Drinks::getPrice).sum();
    }

    //calls check() method of each object from 'ingredients' collection.
    private void checkMachine(){
        ingredients.forEach(this::check);
    }

    //check if any value of 'ingredients' collection is equal or less than 0. If true, add String message error into
    //'errors' collection.
    private void check(String name, double value){
        if (value<=0) errors.add(name+" is absent");
    }

    //This method calls addIngredients() method if there is any error in 'errors' collection to fill out
    //the 'ingredients' collection.
    private void ifError(){
        if (!errors.isEmpty()){
            System.out.println("Press 'Enter' to fill out the machine with ingredients");
            Tech.GetInputStringFunction();
            addIngredients();
            System.out.println("Machine is full of ingredients now");
        }
    }


    //This is an abstraction of water boiling. Actually returns the same value as receives in parameter.
    public double boilWater(double w, int t){
        return w * t / t;
    }

    //This method deducts received as parameters values from values with 'coffee' and 'water' keys in 'ingredients' collection.
    public void makeEspresso(double c, double w){
        ingredients.replace("coffee", ingredients.get("coffee") - c);
        ingredients.replace("water", ingredients.get("water") - w);
    }

    //This is an abstraction of milk whisking. Actually returns the same value as receives in parameter.
    public double whiskMilk(double m, double t){
        return m * t / t;
    }

    //This method deducts received as a parameter value from value with 'water' key in 'ingredients' collection.
    public void addWater(double w){
        ingredients.replace("water", ingredients.get("water") - w);
    }

    //This method deducts received as a parameter value from value with 'milk' key in 'ingredients' collection.
    public void addMilk(double m){
        ingredients.replace("milk", ingredients.get("milk") - m);
    }

    //This method deducts received as a parameter value from value with 'black tea' key in 'ingredients' collection.
    public void addBlackTea(double tea) {
        ingredients.replace("black tea", ingredients.get("black tea") - tea);
    }

    //This method deducts received as a parameter value from value with 'green tea' key in 'ingredients' collection.
    public void addGreenTea(double tea) {
        ingredients.replace("green tea", ingredients.get("green tea") - tea);
    }

}
