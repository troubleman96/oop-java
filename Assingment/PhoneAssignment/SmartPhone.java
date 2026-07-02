public class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, int batteryLevel, String operatingSystem) {
        super(brand, batteryLevel);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public void makeCall() {
        System.out.println(getBrand() + " makes a video call over the internet");
    }
}
