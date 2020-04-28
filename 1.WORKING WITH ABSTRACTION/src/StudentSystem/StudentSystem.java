package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
   private StudentsRepository repository;

    public StudentSystem(StudentsRepository repository) {
        this.repository = repository;
    }

    public void ExecuteCommand(String[] args) {
        if (args[0].equals("Create")) {
            createStudent(args);
        } else if (args[0].equals("Show")) {
            showStudent(args[1]);
        }
    }

    private void createStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        if (!repository.exists(name)) {
            Student student = new Student(name, age, grade);
            repository.addStudent(student);
        }
    }

    private void showStudent(String name) {
        if (repository.exists(name)) {
            Student student = repository.getByName(name);
            System.out.println(student.toString());
        }
    }
}
