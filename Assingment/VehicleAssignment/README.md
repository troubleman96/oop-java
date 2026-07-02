# Vehicle Assignment — Inheritance & Polymorphism in Java

This project demonstrates core OOP concepts — **inheritance**, **method overriding**, **abstract classes**, and **polymorphism** — through a simple vehicle hierarchy.

---

## Project Structure

```
VehicleAssignment/
├── Vehicle.java       — abstract base class
├── Car.java           — subclass of Vehicle
├── Motorcycle.java    — subclass of Vehicle
├── Main.java          — driver class
└── README.md          — this file
```

---

## Class Breakdown

### `Vehicle.java` — Abstract Parent Class

- Declared `abstract`, so it **cannot be instantiated** directly.
- Fields: `private String brand`, `private int speed`.
- Constructor: `Vehicle(String brand)` — initializes brand and sets speed to 0.
- Concrete methods: `getBrand()`, `getSpeed()`, `setSpeed()` (with validation: speed ≥ 0).
- **Abstract method**: `public abstract void move();` — no body; subclasses must override it.
- `displayInfo()` — prints brand and speed, then calls `move()`. This is where **polymorphism** kicks in: the actual `move()` executed depends on the object's runtime type.

### `Car.java` — Subclass of Vehicle

```java
public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int numberOfDoors) {
        super(brand);               // calls Vehicle(String) constructor
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " drives smoothly on four wheels");
    }
}
```

Key points:
| Concept | How it's used |
|---|---|
| `extends` | Car inherits all non-private members of Vehicle |
| `super(brand)` | Invokes the parent constructor to initialize `brand` |
| `numberOfDoors` | Car-specific field — not in Vehicle |
| `@Override move()` | Provides the car's implementation of the abstract `move()` |

### `Motorcycle.java` — Subclass of Vehicle

Same structure as Car, but with a `boolean hasSidecar` field and its own `move()`:
```java
@Override
public void move() {
    System.out.println(getBrand() + " zooms on two wheels");
}
```

### `Main.java` — Demonstration

```java
Car car = new Car("Toyota", 4);
car.setSpeed(80);

Motorcycle motorcycle = new Motorcycle("Yamaha", false);
motorcycle.setSpeed(60);

Vehicle[] vehicles = { car, motorcycle };

for (Vehicle vehicle : vehicles) {
    vehicle.displayInfo();   // polymorphic call to move()
}
```

Output:
```
Toyota is moving at 80 km/h
Toyota drives smoothly on four wheels
Yamaha is moving at 60 km/h
Yamaha zooms on two wheels
Toyota has 4 doors
Yamaha has sidecar: false
```

---

## OOP Concepts Demonstrated

| Concept | Explanation |
|---|---|
| **Inheritance** | `Car` and `Motorcycle` reuse `brand`, `speed`, getters/setters from `Vehicle` via `extends`. |
| **Abstract Class** | `Vehicle` is declared `abstract` and contains an abstract `move()` method, forcing subclasses to implement it. |
| **Method Overriding** | Both subclasses provide their own `@Override` of `move()`. At runtime, the correct version runs based on the object's actual class. |
| **Polymorphism** | The `Vehicle[]` array holds `Car` and `Motorcycle` objects. The loop calls `displayInfo()` → `move()` on each, and Java dispatches to the correct subclass method. |
| **Constructor Chaining** | `super(brand)` in subclass constructors ensures the parent's state is initialized before the subclass adds its own. |
| **Encapsulation** | Fields are `private`; access is through public getters/setters (`getBrand()`, `setSpeed()`, `getNumberOfDoors()`). |

---

## How to Run

```bash
javac Vehicle.java Car.java Motorcycle.java Main.java
java Main
```
