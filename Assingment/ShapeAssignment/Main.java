public class Main {

    public static void main(String[] args) {
        
        Triangle triangle = new Triangle("Red", 6, 4);
        Square square = new Square("Blue", 5);

        Shape[] shapes = { triangle, square };

        for (Shape shape : shapes) {
            shape.displayInfo();
        }

        System.out.println("Triangle base: " + triangle.getBase() + ", height: " + triangle.getHeight());
        System.out.println("Square side: " + square.getSide());
    }
}
