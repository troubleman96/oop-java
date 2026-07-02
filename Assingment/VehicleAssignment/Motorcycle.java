public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, boolean hasSidecar) {
        super(brand);
        this.hasSidecar = hasSidecar;
    }

    public boolean getHasSidecar() {
        return hasSidecar;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " zooms on two wheels");
    }
}
