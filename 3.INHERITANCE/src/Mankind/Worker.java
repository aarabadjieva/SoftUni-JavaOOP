package Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setLastName(lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    public double getWorkHoursperDay() {
        return workHoursPerDay;
    }

    public double getSalaryPerHour() {
        return this.weekSalary / (this.getWorkHoursperDay() * 7.00);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Week Salary: %.2f\n" +
                "Hours per day: %.2f\n" +
                "Salary per hour: %.2f",this.getWeekSalary(),this.getWorkHoursperDay(),this.getSalaryPerHour());
    }
}
