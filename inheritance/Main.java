public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();
        d.name = "Simba";

        d.eat();   // inherited from Animal
        d.bark();  // Dog's own method

    }
}
