public abstract class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    public abstract void move();

    public void displayInfo() {
        System.out.println(brand + " is moving at " + speed + " km/h");
        move();
    }
}
