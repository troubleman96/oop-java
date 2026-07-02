class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println("Car: turn key to start engine");
    }

    @Override
    void stop() {
        System.out.println("Car: press brake to stop");
    }
}
