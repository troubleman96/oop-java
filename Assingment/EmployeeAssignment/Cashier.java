public class Cashier extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public Cashier(String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}
