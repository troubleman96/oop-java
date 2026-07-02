# Abstraction — Hiding Complexity

This project demonstrates **abstract classes** and **method overriding** by modeling vehicles with a shared abstract contract.

---

## Files

| File | Role |
|---|---|
| `Vehicle.java` | Abstract parent — declares `start()` and `stop()` as abstract, provides `displayBrand()` |
| `Car.java` | Subclass — implements `start()` as *"turn key"* and `stop()` as *"press brake"* |
| `Bike.java` | Subclass — implements `start()` as *"kickstart"* and `stop()` as *"press brakes"* |
| `Main.java` | Driver — creates Car and Bike through Vehicle references |

---

## Code

### `Vehicle.java`
```java
abstract class Vehicle {
    private String brand;

    Vehicle(String brand) { this.brand = brand; }

    abstract void start();
    abstract void stop();

    void displayBrand() { System.out.println("Brand: " + brand); }
}
```

- `abstract class` → cannot be instantiated (`new Vehicle(...)` is illegal).
- `abstract void start()` and `abstract void stop()` → no body; subclasses **must** override them.
- `displayBrand()` → concrete method inherited as-is.

### `Car.java`
```java
class Car extends Vehicle {
    Car(String brand) { super(brand); }

    @Override void start() { System.out.println("Car: turn key to start engine"); }
    @Override void stop()  { System.out.println("Car: press brake to stop"); }
}
```

### `Bike.java`
```java
class Bike extends Vehicle {
    Bike(String brand) { super(brand); }

    @Override void start() { System.out.println("Bike: kickstart to start engine"); }
    @Override void stop()  { System.out.println("Bike: press brakes to stop"); }
}
```

---

## Main.java — Deep Explanation

```java
public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Toyota");
        Vehicle myBike = new Bike("Yamaha");

        myCar.displayBrand();
        myCar.start();
        myCar.stop();

        System.out.println();

        myBike.displayBrand();
        myBike.start();
        myBike.stop();
    }
}
```

**`Vehicle myCar = new Car("Toyota");`**
- Reference type: `Vehicle`. Object type: `Car`. This is **upcasting**.
- Constructor chain: `Car("Toyota")` → `super("Toyota")` → `Vehicle("Toyota")` sets `brand = "Toyota"`.

**`myCar.displayBrand();`** — Calls inherited concrete method → prints `"Brand: Toyota"`.

**`myCar.start();`** — **Dynamic dispatch**: the JVM sees the actual object is `Car`, so `Car.start()` runs → `"Car: turn key to start engine"`.

**`myCar.stop();`** — Likewise dispatches to `Car.stop()` → `"Car: press brake to stop"`.

Same pattern for `myBike` — same `Vehicle` reference type, but `Bike`'s overrides execute.

### Output

```
Brand: Toyota
Car: turn key to start engine
Car: press brake to stop

Brand: Yamaha
Bike: kickstart to start engine
Bike: press brakes to stop
```

---

## OOP Concepts

| Concept | Where |
|---|---|
| **Abstraction** | `Vehicle` hides implementation details — subclasses define *how* to start/stop |
| **Abstract class** | `Vehicle` uses `abstract` keyword and contains abstract methods |
| **Method overriding** | `Car` and `Bike` each `@Override start()` and `stop()` |
| **Polymorphism** | `Vehicle` references hold `Car` / `Bike` objects; correct method runs at runtime |
| **Constructor chaining** | `super(brand)` initializes the parent's private `brand` |

---

## Run

```bash
javac Vehicle.java Car.java Bike.java Main.java
java Main
```
