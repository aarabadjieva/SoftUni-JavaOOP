package StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getGrade() {
        return grade;
    }

    private String getComment() {
        String comment;
        if (this.getGrade() >= 5.00) {
            comment = "Excellent student.";
        } else if (this.getGrade() < 5.00 && this.getGrade() >= 3.50) {
            comment = "Average student.";
        } else {
            comment = "Very nice person.";
        }
        return comment;
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old. %s", this.getName(), this.getAge(), this.getComment());
    }
}
