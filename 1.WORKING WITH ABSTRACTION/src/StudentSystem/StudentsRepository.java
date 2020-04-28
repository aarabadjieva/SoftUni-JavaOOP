package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentsRepository {
    private Map<String, Student> storage;

    public StudentsRepository() {
        this.storage = new HashMap<>();
    }

    public boolean exists(String name){
        return this.storage.containsKey(name);
    }
    public Student getByName(String name){
        return this.storage.get(name);
    }
    public void addStudent(Student student){
        this.storage.put(student.getName(),student);
    }
}
