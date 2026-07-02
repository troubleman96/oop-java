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
