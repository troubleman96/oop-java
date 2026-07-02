# Encapsulation — Data Hiding & Controlled Access

This project demonstrates **encapsulation**: keeping fields `private` and exposing them through public getters/setters with validation.

---

## Files

| File | Role |
|---|---|
| `BankAccount.java` | Encapsulated account with a `private balance` and validated `deposit()` |
| `Student.java` | Encapsulated student with `private name` and `private age` (age validated > 0) |
| `Main.java` | Driver — creates a `Student`, sets fields via setters, reads via getters |

---

## Code Breakdown

### `BankAccount.java`

```java
public class BankAccount {
    private double balance;  // hidden — no direct access from outside

    public double getBalance() {
        return balance;       // read-only access
    }

    public void deposit(double amount) {
        if (amount > 0) {     // validation: reject negative/zero deposits
            balance = balance + amount;
        }
    }
}
```

| Feature | Purpose |
|---|---|
| `private double balance` | Nobody outside the class can read or write `balance` directly |
| `getBalance()` | Public **getter** — controlled read access |
| `deposit()` | Public **setter** — only allows positive amounts (validation) |

### `Student.java`

```java
public class Student {
    private String name;
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age > 0) {        // guards against invalid data
            this.age = age;
        }
    }
}
```

- Fields are `private` — cannot be accessed as `s.name` or `s.age` from outside.
- Getters provide read access; setters provide write access **with validation**.
- `this.name = name` — `this` disambiguates the field from the parameter.

### `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setName("John");
        s.setAge(20);

        System.out.println(s.getName());  // John
        System.out.println(s.getAge());   // 20
    }
}
```

- Cannot write `s.name = "John"` — compiler error because `name` is private.
- Must go through `s.setName(...)` / `s.getName()` — the **encapsulated** path.

### Output

```
John
20
```

---

## OOP Concepts

| Concept | Where |
|---|---|
| **Encapsulation** | All fields are `private`; access is only through public methods |
| **Data hiding** | `balance`, `name`, `age` cannot be directly read or modified from outside |
| **Validation** | `deposit()` rejects negative amounts; `setAge()` rejects ages ≤ 0 |
| **Getters / Setters** | Standard pattern for controlled access to private fields |

---

## Run

```bash
javac BankAccount.java Student.java Main.java
java Main
```
