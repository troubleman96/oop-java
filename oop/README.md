# OOP Basics — Classes & Objects

This project demonstrates the most fundamental OOP concept: a **class** is a blueprint and an **object** is a concrete instance built from that blueprint.

---

## Files

| File | Role |
|---|---|
| `food.java` | Blueprint for a `Food` item with `food_name`, `price`, and `order()` |
| `Phone.java` | Blueprint for a `Phone` with `model`, `battery`, and `call()` |

---

## Code Breakdown

### `Phone.java`

```java
public class Phone {
    String model;
    int    battery;

    public void call() {
        System.out.println("Calling...");
    }

    public static void main(String[] args) {
        Phone myPhone = new Phone();
        myPhone.model   = "Galaxy A15";
        myPhone.battery = 80;
        myPhone.call();

        Phone friendPhone = new Phone();
        friendPhone.model   = "iPhone 14";
        friendPhone.battery = 55;
        friendPhone.call();

        System.out.println("My phone: "       + myPhone.model     + " — " + myPhone.battery     + "%");
        System.out.println("Friend's phone: " + friendPhone.model + " — " + friendPhone.battery + "%");
    }
}
```

| Concept | Detail |
|---|---|
| **Class** (blueprint) | `Phone` — defines what fields (`model`, `battery`) and methods (`call()`) every phone object has |
| **Object** (instance) | `new Phone()` creates a concrete phone in memory |
| **Dot operator** | `myPhone.model`, `myPhone.call()` — access fields / invoke methods on an object |
| **Multiple instances** | `myPhone` and `friendPhone` are independent — changing one doesn't affect the other |

### `food.java`

```java
public class food {
    String food_name;
    int price;

    public void order() {
        System.out.println("ordering...");
    }

    public static void main(String[] args) {
        food chipsi = new food();
        chipsi.food_name = "Chipsi";
        chipsi.price = 100;
        chipsi.order();

        food pilau = new food();
        pilau.food_name = "Pilau";
        pilau.price = 150;
        pilau.order();
    }
}
```

Same pattern — shows the blueprint/instance concept with a different domain.

### Output

```
Calling...
Calling...
My phone: Galaxy A15 — 80%
Friend's phone: iPhone 14 — 55%
ordering...
Food name: Chipsi — Price: 100
ordering...
Food name: Pilau — Price: 150
```

---

## OOP Concepts

| Concept | Where |
|---|---|
| **Class** | `Phone` and `food` are blueprints that define structure and behavior |
| **Object** | `new Phone()`, `new food()` create concrete instances |
| **Fields** | `model`, `battery`, `food_name`, `price` — data each object holds |
| **Methods** | `call()`, `order()` — behavior each object can perform |
| **Multiple instances** | Two separate `Phone` objects and two separate `food` objects, each with their own data |

---

## Run

```bash
javac Phone.java food.java
java Phone
java food
```
