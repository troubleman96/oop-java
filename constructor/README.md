# Constructors — Initializing Objects

This project demonstrates **constructors**: how they initialize object state at creation time, and how `this` disambiguates parameters from fields.

---

## Files

| File | Role |
|---|---|
| `constructor.java` | Blueprint for a `Student`-like object with a parameterized constructor |
| `my_constructor.java` | Another example modeling a `User` profile with name, age, and location |

---

## Code Breakdown

### `constructor.java`

```java
public class constructor {
    String name;
    int    age;
    String course;

    public constructor(String name, int age, String course) {
        this.name   = name;
        this.age    = age;
        this.course = course;
    }

    public void introduce() {
        System.out.println("Hi, I am " + name + ", age "
                           + age + ", studying " + course);
    }

    public static void main(String[] args) {
        constructor student1 = new constructor("Emmanuel", 20, "Computer Science");
        constructor student2 = new constructor("Amina", 22, "Software Engineering");

        student1.introduce();
        student2.introduce();

        System.out.println(student1.name + " is " + student1.age + " years old");
        System.out.println(student2.name + " is " + student2.age + " years old");
    }
}
```

| Concept | Detail |
|---|---|
| **Constructor** | Same name as the class, no return type. Called automatically on `new`. |
| **`this` keyword** | `this.name = name` — `this.name` refers to the **field**, `name` refers to the **parameter**. Without `this`, Java would think you're assigning the parameter to itself (no-op). |
| **Parameterized constructor** | Accepts arguments to set all fields at creation — no need for separate setter calls. |
| **Multiple objects** | `student1` and `student2` are independent instances with their own data. |

### `my_constructor.java`

```java
public class my_constructor {
    String user_name;
    int user_age;
    String location;

    public my_constructor(String user_name, int user_age, String location) {
        this.user_name = user_name;
        this.user_age  = user_age;
        this.location  = location;
    }

    public void introduction() {
        System.out.println("Habari, I am " + user_name + ", age "
                           + user_age + " and I live in " + location);
    }

    public static void main(String[] args) {
        my_constructor user1 = new my_constructor("Emmanuel", 20, "Nairobi");
        my_constructor user2 = new my_constructor("Amina", 22, "Mombasa");

        user1.introduction();
        user2.introduction();
    }
}
```

Same pattern — illustrates that the constructor pattern works the same regardless of field names or class purpose.

### Output

```
Hi, I am Emmanuel, age 20, studying Computer Science
Hi, I am Amina, age 22, studying Software Engineering
Emmanuel is 20 years old
Amina is 22 years old
Habari, I am Emmanuel, age 20 and I live in Nairobi
Habari, I am Amina, age 22 and I live in Mombasa
```

---

## OOP Concepts

| Concept | Where |
|---|---|
| **Constructor** | Parameterized constructors initialize all fields at object creation |
| **`this` keyword** | Resolves naming conflict between parameters and fields |
| **Object state** | Each object (`student1` / `student2`, `user1` / `user2`) holds its own independent data |
| **Encapsulation (basic)** | Fields are package-private; direct access from `main()` in the same class |

---

## Run

```bash
javac constructor.java my_constructor.java
java constructor
java my_constructor
```
