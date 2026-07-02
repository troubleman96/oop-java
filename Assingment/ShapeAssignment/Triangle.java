public class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color); //to intailziae the parents constructor 
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}
