class Bike extends Vehicle {
    Bike(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println("Bike: kickstart to start engine");
    }

    @Override
    void stop() {
        System.out.println("Bike: press brakes to stop");
    }
}
