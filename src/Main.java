public class Main {
    public static void main(String[] args) {

        //Create new Machine object
        Machine machine = new Machine();

        //start() method call, that fills 'menu' HashMap collection
        machine.start();

        //add elements into ingredients HashMap collection
        machine.addIngredients();

        //start menu and UI
        machine.callMenu();
    }
}
