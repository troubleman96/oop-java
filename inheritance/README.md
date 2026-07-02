# Inheritance — Reusing Parent Behavior

This project demonstrates **inheritance**: a `Dog` class extends `Animal` to inherit fields and methods, then adds its own behavior.

---

## Files

| File | Role |
|---|---|
| `Animal.java` | Parent class — has `name` field and `eat()` method |
| `Dog.java` | Subclass — `extends Animal`, inherits `eat()`, adds `bark()` |
| `Main.java` | Driver — creates an `Animal` object |

---

## Code Breakdown

### `Animal.java` — Parent Class

```java
public class Animal {
    String name;

    public void eat() {
        System.out.println(name + " is eating");
    }
}
```

- Has a `name` field (package-private).
- Has a concrete `eat()` method that any subclass inherits.

### `Dog.java` — Subclass

```java
public class Dog extends Animal {
    String name;

    public void bark() {
        System.out.println(name + " says Woof!!");
    }
}
```

- `extends Animal` → Dog inherits `eat()` from Animal.
- Adds its own `bark()` method.
- Note: `Dog` declares its own `name` field — this **shadows** Animal's `name`. In practice, one or the other should be used, not both.

### `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        // a.eat();   // Would print: "null is eating" (name not set)
    }
}
```

---

## OOP Concepts

| Concept | Where |
|---|---|
| **Inheritance** | `Dog extends Animal` — Dog inherits `eat()` without rewriting it |
| **Code reuse** | `eat()` is defined once in `Animal`, available to all subclasses |
| **Method addition** | `Dog` adds `bark()` — specialized behavior not in the parent |
| **`extends` keyword** | Java keyword for single-class inheritance |

---

## Run

```bash
javac Animal.java Dog.java Main.java
java Main
```
