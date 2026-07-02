# Shape Assignment — Abstract Classes & Polymorphism

This project demonstrates **abstract classes**, **method overriding**, **constructor chaining**, and **polymorphism** through a shape hierarchy.

---

## Project Structure

```
ShapeAssignment/
├── Shape.java       — abstract base class
├── Triangle.java    — subclass of Shape
├── Square.java      — subclass of Shape
├── Main.java        — driver class
└── README.md        — this file
```

---

## Class Breakdown

### `Shape.java` — Abstract Parent Class

```java
public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
    }

    public abstract double area();      // subclasses MUST implement

    public void displayInfo() {
        System.out.println(color + " shape has area " + area());  // polymorphic call
    }
}
```

| Feature | Detail |
|---|---|
| `abstract` class | Cannot be instantiated — only used as a base for subclasses |
| `color` field | Private with public getter/setter (encapsulation) |
| `abstract double area()` | No body — forces subclasses to provide their own area calculation |
| `displayInfo()` | Concrete method that calls the abstract `area()` — **polymorphism point** |

### `Triangle.java` — Subclass of Shape

```java
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);       // initializes Shape's color
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;     // ½ × base × height
    }
}
```

### `Square.java` — Subclass of Shape

```java
public class Square extends Shape {
    private double side;

    public Square(String color, double side) {
        super(color);       // initializes Shape's color
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;             // side²
    }
}
```

---

## Main.java — Deep Explanation

```java
public class Main {
    public static void main(String[] args) {

        Triangle triangle = new Triangle("Red", 6, 4);
        Square square = new Square("Blue", 5);

        Shape[] shapes = { triangle, square };

        for (Shape shape : shapes) {
            shape.displayInfo();
        }

        System.out.println("Triangle base: " + triangle.getBase()
                           + ", height: " + triangle.getHeight());
        System.out.println("Square side: " + square.getSide());
    }
}
```

### Line-by-Line

#### `Triangle triangle = new Triangle("Red", 6, 4);`

- Calls `Triangle(String, double, double)` constructor.
- **Constructor chain**: `Triangle("Red", 6, 4)` → `super("Red")` → `Shape("Red")` sets `color = "Red"`. Then Triangle sets `base = 6`, `height = 4`.
- Object state: `color = "Red"`, `base = 6.0`, `height = 4.0`.

#### `Square square = new Square("Blue", 5);`

- `Square("Blue", 5)` → `super("Blue")` → `color = "Blue"`. Then `side = 5`.
- Object state: `color = "Blue"`, `side = 5.0`.

#### `Shape[] shapes = { triangle, square };`

- Array declared as `Shape[]` (parent type).
- Both objects are **upcast** implicitly: `Triangle` is-a `Shape`, `Square` is-a `Shape`.
- Compile-time type: `Shape`. Runtime type: `Triangle` / `Square`.

#### `for (Shape shape : shapes) { shape.displayInfo(); }`

- **Iteration 1**: `shape` refers to the `Triangle` object.
  - `displayInfo()` (from Shape) runs.
  - Inside it: `this.area()` is called. Which `area()`?
  - **Dynamic dispatch**: JVM checks the actual object — it's a `Triangle` — so `Triangle.area()` runs → `0.5 * 6 * 4 = 12.0`.
  - Prints: `Red shape has area 12.0`

- **Iteration 2**: `shape` refers to the `Square` object.
  - `displayInfo()` runs again, but now `this.area()` dispatches to `Square.area()` → `5 * 5 = 25.0`.
  - Prints: `Blue shape has area 25.0`

This is the key polymorphic behavior: **same method call (`area()`), different behavior based on the actual object type**.

#### Final Two Print Statements

```java
System.out.println("Triangle base: " + triangle.getBase()
                   + ", height: " + triangle.getHeight());
System.out.println("Square side: " + square.getSide());
```

- `triangle.getBase()` / `triangle.getHeight()` — **Triangle-specific** methods, only callable through a `Triangle` reference.
- `square.getSide()` — **Square-specific** method.
- These demonstrate that even though we used `Shape[]` for polymorphic iteration, we still have access to subclass-specific members when using the original typed references.

### Output

```
Red shape has area 12.0
Blue shape has area 25.0
Triangle base: 6.0, height: 4.0
Square side: 5.0
```

---

## OOP Concepts Demonstrated

| Concept | Where |
|---|---|
| **Abstract Class** | `Shape` is `abstract` with `abstract double area()`. |
| **Inheritance** | `Triangle` and `Square` inherit `color`, getters, `displayInfo()` from `Shape`. |
| **Method Overriding** | Both subclasses `@Override area()` with their own formula. |
| **Polymorphism** | `Shape[]` holds `Triangle` and `Square`; the loop calls `area()` via `Shape` reference, but the correct subclass version runs. |
| **Constructor Chaining** | `super(color)` in both subclasses ensures `Shape`'s `color` is initialized first. |
| **Encapsulation** | `color` is private; accessed via `getColor()` / `setColor()`. |
| **Upcasting** | `Triangle` and `Square` stored in `Shape[]` without explicit cast. |

---

## How to Run

```bash
javac Shape.java Triangle.java Square.java Main.java
java Main
```
