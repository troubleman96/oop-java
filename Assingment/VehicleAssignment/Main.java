public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 4);
        car.setSpeed(80);

        Motorcycle motorcycle = new Motorcycle("Yamaha", false);
        motorcycle.setSpeed(60);

        Vehicle[] vehicles = { car, motorcycle };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }

        System.out.println(car.getBrand() + " has " + car.getNumberOfDoors() + " doors");
        System.out.println(motorcycle.getBrand() + " has sidecar: " + motorcycle.getHasSidecar());
    }
}
