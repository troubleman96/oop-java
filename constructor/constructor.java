// #CLASS = blueprint for a Student
// Without a constructor you'd have to set every field manually after creation.
// A constructor lets you pass in the values at the moment you create the object.
public class constructor {

    // FIELDS — data every Student object holds
    String name;
    int    age;
    String course;

    // CONSTRUCTOR — same name as the class, no return type
    // Java calls this automatically when you write: new constructor(...)
    public constructor(String name, int age, String course) {
        // 'this' refers to the current object being created.
        // Without 'this', Java would confuse the field and the parameter
        // because they share the same name.
        this.name   = name;
        this.age    = age;
        this.course = course;
    }

    // METHOD — something every Student object can do
    public void introduce() {
        System.out.println("Hi, I am " + name + ", age " + age + ", studying " + course);
    }

    public static void main(String[] args) {

        // The constructor runs here — values are set in one line at creation time
        constructor student1 = new constructor("Emmanuel", 20, "Computer Science");
        constructor student2 = new constructor("Amina", 22, "Software Engineering");

        student1.introduce(); // Hi, I am Emmanuel, age 20, studying Computer Science
        student2.introduce(); // Hi, I am Amina, age 22, studying Software Engineering

        // Each object keeps its own separate data
        System.out.println(student1.name + " is " + student1.age + " years old");
        System.out.println(student2.name + " is " + student2.age + " years old");
    }
}
