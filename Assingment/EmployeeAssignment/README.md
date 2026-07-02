# Employee Assignment — Abstract Classes & Polymorphism

This project demonstrates **abstract classes**, **method overriding**, **constructor chaining**, and **polymorphism** through an employee salary hierarchy.

---

## Project Structure

```
EmployeeAssignment/
├── Employee.java     — abstract base class
├── Manager.java      — subclass of Employee
├── Cashier.java      — subclass of Employee
├── Main.java         — driver class
└── README.md         — this file
```

---

## Class Breakdown

### `Employee.java` — Abstract Parent Class

```java
public abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println(name + " earns " + calculateSalary());  // polymorphic call
    }
}
```

| Feature | Detail |
|---|---|
| `abstract` class | Cannot be instantiated — serves as a base for subclasses |
| `name`, `baseSalary` | Private fields with getters; `setBaseSalary()` validates ≥ 0 |
| `abstract double calculateSalary()` | Subclasses implement their own salary logic |
| `displayInfo()` | Concrete method that calls `calculateSalary()` — **polymorphism point** |

### `Manager.java` — Subclass of Employee

```java
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;   // base + fixed bonus
    }
}
```

### `Cashier.java` — Subclass of Employee

```java
public class Cashier extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public Cashier(String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);  // base + overtime pay
    }
}
```

---

## Main.java — Deep Explanation

```java
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Amina", 500000, 150000);
        Cashier cashier = new Cashier("Juma", 200000, 20, 5000);

        Employee[] employees = { manager, cashier };

        for (Employee employee : employees) {
            employee.displayInfo();
        }

        System.out.println(manager.getName() + " bonus: " + manager.getBonus());
        System.out.println(cashier.getName() + " hours worked: " + cashier.getHoursWorked());
    }
}
```

### Line-by-Line

**`Manager manager = new Manager("Amina", 500000, 150000);`**
- Calls `Manager(String, double, double)` constructor.
- **Constructor chain**: `Manager(...)` → `super("Amina", 500000)` → `Employee("Amina", 500000)` sets `name = "Amina"`, `baseSalary = 500000`. Then Manager sets `bonus = 150000`.

**`Cashier cashier = new Cashier("Juma", 200000, 20, 5000);`**
- `Cashier(...)` → `super("Juma", 200000)` → `name = "Juma"`, `baseSalary = 200000`. Then sets `hoursWorked = 20`, `hourlyRate = 5000`.

**`Employee[] employees = { manager, cashier };`**
- Array typed as `Employee[]` (parent type). Both objects are **upcast** implicitly.
- Compile-time type: `Employee`. Runtime type: `Manager` / `Cashier`.

**`for (Employee employee : employees) { employee.displayInfo(); }`**
- **Iteration 1**: `employee` → Manager object.
  - `displayInfo()` calls `this.calculateSalary()`.
  - **Dynamic dispatch** routes to `Manager.calculateSalary()` → `500000 + 150000 = 650000`.
  - Prints: `"Amina earns 650000.0"`.
- **Iteration 2**: `employee` → Cashier object.
  - `this.calculateSalary()` dispatches to `Cashier.calculateSalary()` → `200000 + (20 * 5000) = 300000`.
  - Prints: `"Juma earns 300000.0"`.

**Final print statements:**
- `manager.getName()` — inherited → `"Amina"`.
- `manager.getBonus()` — **Manager-specific** → `150000.0`.
- `cashier.getName()` — inherited → `"Juma"`.
- `cashier.getHoursWorked()` — **Cashier-specific** → `20`.

### Output

```
Amina earns 650000.0
Juma earns 300000.0
Amina bonus: 150000.0
Juma hours worked: 20
```

---

## OOP Concepts Demonstrated

| Concept | Where |
|---|---|
| **Abstract Class** | `Employee` is `abstract` with `abstract double calculateSalary()`. |
| **Inheritance** | `Manager` and `Cashier` inherit `name`, `baseSalary`, getters, `displayInfo()`. |
| **Method Overriding** | Both subclasses `@Override calculateSalary()` with their own formula. |
| **Polymorphism** | `Employee[]` holds both types; the loop calls `calculateSalary()` via `Employee` reference, but the correct subclass version runs. |
| **Constructor Chaining** | `super(name, baseSalary)` in both subclasses. |
| **Encapsulation** | Fields are `private`; accessed via public getters. `setBaseSalary()` validates ≥ 0. |
| **Upcasting** | `Manager` and `Cashier` stored in `Employee[]` without explicit cast. |

---

## How to Run

```bash
javac Employee.java Manager.java Cashier.java Main.java
java Main
```
