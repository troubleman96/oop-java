public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Toyota");
        Vehicle myBike = new Bike("Yamaha");

        myCar.displayBrand();
        myCar.start();
        myCar.stop();

        System.out.println();

        myBike.displayBrand();
        myBike.start();
        myBike.stop();
    }
}
