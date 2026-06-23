// CLASS = the blueprint for a Food item
public class food {

    // FIELDS — data every food object carries
    String food_name;
    int price;

    // METHOD — an action every food object can perform
    public void order() {
        System.out.println("ordering...");
    }

    public static void main(String[] args) {

        // OBJECT 1 — build a food object called chipsi
        food chipsi = new food();
        chipsi.food_name = "Chipsi";
        chipsi.price = 100;

        chipsi.order(); // prints: ordering...
        System.out.println("Food name: " + chipsi.food_name + " — " + "Price: " + chipsi.price);

        // OBJECT 2 — a completely separate food object
        food pilau = new food();
        pilau.food_name = "Pilau";
        pilau.price = 150;

        pilau.order(); // prints: ordering...
        System.out.println("Food name: " + pilau.food_name + " — " + "Price: " + pilau.price);
    }
}
