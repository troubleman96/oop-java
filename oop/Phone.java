// CLASS = the blueprint. It defines what a Phone IS and what it can DO.
public class Phone {

    // FIELDS (data) — every Phone object will have these
    String model;
    int    battery;

    // METHOD (action) — something every Phone object can do
    public void call() {
        System.out.println("Calling...");
    }

    // main() is the entry point — Java runs this first
    public static void main(String[] args) {

        // OBJECT = a real Phone built from the blueprint
        Phone myPhone = new Phone();

        // Set the object's data
        myPhone.model   = "Galaxy A15";
        myPhone.battery = 80;

        // Call the object's action
        myPhone.call(); // prints: Calling...

        // You can make as many objects as you want from one class
        Phone friendPhone = new Phone();
        friendPhone.model   = "iPhone 14";
        friendPhone.battery = 55;
        friendPhone.call(); // prints: Calling...

        // Print their data to see they are separate objects
        System.out.println("My phone: "       + myPhone.model     + " — " + myPhone.battery     + "%");
        System.out.println("Friend's phone: " + friendPhone.model + " — " + friendPhone.battery + "%");
    }
}
