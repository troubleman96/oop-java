# Polymorphism — Many Forms

This project demonstrates **polymorphism** (specifically **dynamic method dispatch**): a parent reference can hold a child object, and the correct overridden method runs at runtime based on the actual object type.

---

## Files

| File | Role |
|---|---|
| `Animal.java` | Parent class — has `makeSound()` that prints `"Some sound"` |
| `Cat.java` | Subclass — `@Override makeSound()` to print `"Meow"` |
| `Dog.java` | Subclass — `@Override makeSound()` to print `"Woof"` |
| `Main.java` | Driver — upcasts Cat and Dog to Animal references, calls `makeSound()` |

---

## Code Breakdown

### `Animal.java` — Parent Class

```java
public class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}
```

- Has a concrete `makeSound()` method that subclasses can override.

### `Cat.java` — Subclass

```java
public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
```

### `Dog.java` — Subclass

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}
```

---

## Main.java — Deep Explanation

```java
public class Main {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.makeSound();  // Output: Meow

        Animal b = new Dog();
        b.makeSound();  // Output: Woof
    }
}
```

**`Animal a = new Cat();`**
- Reference type: `Animal` (compile-time type).
- Actual object type: `Cat` (runtime type).
- This is **upcasting** — a `Cat` **is-a** `Animal`, so it fits.

**`a.makeSound();`**
- At **compile time**, Java checks only that `Animal` has `makeSound()` — it does.
- At **runtime**, the JVM looks at the actual object: it's a `Cat`, so `Cat.makeSound()` executes → `"Meow"`.

**`Animal b = new Dog();`**
- Same pattern — reference is `Animal`, object is `Dog`.

**`b.makeSound();`** → dispatches to `Dog.makeSound()` → `"Woof"`.

This is **dynamic method dispatch** (runtime polymorphism): the same method call (`makeSound()`) produces different behavior depending on which subclass the reference actually points to.

### Output

```
Meow
Woof
```

---

## OOP Concepts

| Concept | Where |
|---|---|
| **Polymorphism** | `Animal` reference can hold a `Cat` or `Dog` object |
| **Method overriding** | `Cat` and `Dog` each `@Override makeSound()` |
| **Dynamic dispatch** | The JVM decides which `makeSound()` to call at runtime, not compile time |
| **Upcasting** | `new Cat()` assigned to `Animal a` — widening the type |
| **Inheritance** | `Cat extends Animal`, `Dog extends Animal` |

---

## Run

```bash
javac Animal.java Cat.java Dog.java Main.java
java Main
```
