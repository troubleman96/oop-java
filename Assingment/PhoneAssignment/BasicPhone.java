public class BasicPhone extends Phone {
    private boolean hasFlashlight;

    public BasicPhone(String brand, int batteryLevel, boolean hasFlashlight) {
        super(brand, batteryLevel);
        this.hasFlashlight = hasFlashlight;
    }

    public boolean getHasFlashlight() {
        return hasFlashlight;
    }

    @Override
    public void makeCall() {
        System.out.println(getBrand() + " makes a normal network call");
    }
}
