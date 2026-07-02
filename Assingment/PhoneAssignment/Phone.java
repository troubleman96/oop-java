public abstract class Phone {
    private String brand;
    private int batteryLevel;

    public Phone(String brand, int batteryLevel) {
        this.brand = brand;
        this.batteryLevel = batteryLevel;
    }

    public String getBrand() {
        return brand;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        }
    }

    public abstract void makeCall();

    public void displayInfo() {
        System.out.println(brand + " battery at " + batteryLevel + "%");
        makeCall();
    }
}
