# Phone Assignment — Abstract Classes & Polymorphism

This project demonstrates **abstract classes**, **method overriding**, **constructor chaining**, and **polymorphism** through a phone hierarchy.

---

## Project Structure

```
PhoneAssignment/
├── Phone.java        — abstract base class
├── SmartPhone.java   — subclass of Phone
├── BasicPhone.java   — subclass of Phone
├── Main.java         — driver class
└── README.md         — this file
```

---

## Class Breakdown

### `Phone.java` — Abstract Parent Class

```java
public abstract class Phone {
    private String brand;
    private int batteryLevel;

    public Phone(String brand, int batteryLevel) {
        this.brand = brand;
        this.batteryLevel = batteryLevel;
    }

    public abstract void makeCall();

    public void displayInfo() {
        System.out.println(brand + " battery at " + batteryLevel + "%");
        makeCall();       // polymorphic call
    }
}
```

| Feature | Detail |
|---|---|
| `abstract` class | Cannot be instantiated — serves as a base for subclasses |
| `brand`, `batteryLevel` | Private fields with getters; `setBatteryLevel()` validates 0–100 |
| `abstract void makeCall()` | Subclasses must implement their own calling behavior |
| `displayInfo()` | Concrete method that calls the abstract `makeCall()` — **polymorphism point** |

### `SmartPhone.java` — Subclass of Phone

```java
public class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, int batteryLevel, String operatingSystem) {
        super(brand, batteryLevel);
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void makeCall() {
        System.out.println(getBrand() + " makes a video call over the internet");
    }
}
```

### `BasicPhone.java` — Subclass of Phone

```java
public class BasicPhone extends Phone {
    private boolean hasFlashlight;

    public BasicPhone(String brand, int batteryLevel, boolean hasFlashlight) {
        super(brand, batteryLevel);
        this.hasFlashlight = hasFlashlight;
    }

    @Override
    public void makeCall() {
        System.out.println(getBrand() + " makes a normal network call");
    }
}
```

---

## Main.java — Deep Explanation

```java
public class Main {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("Samsung", 85, "Android");
        BasicPhone basicPhone = new BasicPhone("Nokia", 60, true);

        Phone[] phones = { smartPhone, basicPhone };

        for (Phone phone : phones) {
            phone.displayInfo();
        }

        System.out.println(smartPhone.getBrand() + " runs " + smartPhone.getOperatingSystem());
        System.out.println(basicPhone.getBrand() + " has flashlight: " + basicPhone.getHasFlashlight());
    }
}
```

### Line-by-Line

**`SmartPhone smartPhone = new SmartPhone("Samsung", 85, "Android");`**
- Calls `SmartPhone(String, int, String)` constructor.
- **Constructor chain**: `SmartPhone(...)` → `super("Samsung", 85)` → `Phone("Samsung", 85)` sets `brand = "Samsung"`, `batteryLevel = 85`. Then SmartPhone sets `operatingSystem = "Android"`.

**`BasicPhone basicPhone = new BasicPhone("Nokia", 60, true);`**
- `BasicPhone(...)` → `super("Nokia", 60)` → `brand = "Nokia"`, `batteryLevel = 60`. Then `hasFlashlight = true`.

**`Phone[] phones = { smartPhone, basicPhone };`**
- Array typed as `Phone[]` (parent type). Both objects are **upcast** implicitly.
- Compile-time type: `Phone`. Runtime type: `SmartPhone` / `BasicPhone`.

**`for (Phone phone : phones) { phone.displayInfo(); }`**
- **Iteration 1**: `phone` → SmartPhone object.
  - `displayInfo()` prints `"Samsung battery at 85%"`.
  - Then calls `this.makeCall()` — **dynamic dispatch** routes to `SmartPhone.makeCall()` → `"Samsung makes a video call over the internet"`.
- **Iteration 2**: `phone` → BasicPhone object.
  - Prints `"Nokia battery at 60%"`.
  - `this.makeCall()` dispatches to `BasicPhone.makeCall()` → `"Nokia makes a normal network call"`.

Same method call (`makeCall()`), different behavior based on actual object type.

**Final print statements:**
- `smartPhone.getBrand()` — inherited → `"Samsung"`.
- `smartPhone.getOperatingSystem()` — **SmartPhone-specific** → `"Android"`.
- `basicPhone.getBrand()` — inherited → `"Nokia"`.
- `basicPhone.getHasFlashlight()` — **BasicPhone-specific** → `true`.

### Output

```
Samsung battery at 85%
Samsung makes a video call over the internet
Nokia battery at 60%
Nokia makes a normal network call
Samsung runs Android
Nokia has flashlight: true
```

---

## OOP Concepts Demonstrated

| Concept | Where |
|---|---|
| **Abstract Class** | `Phone` is `abstract` with `abstract void makeCall()`. |
| **Inheritance** | `SmartPhone` and `BasicPhone` inherit `brand`, `batteryLevel`, getters, `displayInfo()`. |
| **Method Overriding** | Both subclasses `@Override makeCall()` with their own behavior. |
| **Polymorphism** | `Phone[]` holds both types; the loop calls `makeCall()` via `Phone` reference, but the correct subclass version runs at runtime. |
| **Constructor Chaining** | `super(brand, batteryLevel)` in both subclasses. |
| **Encapsulation** | Fields are `private`; accessed via public getters. `setBatteryLevel()` validates range. |
| **Upcasting** | `SmartPhone` and `BasicPhone` stored in `Phone[]` without explicit cast. |

---

## How to Run

```bash
javac Phone.java SmartPhone.java BasicPhone.java Main.java
java Main
```
