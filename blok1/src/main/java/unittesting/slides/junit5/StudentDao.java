package unittesting.slides.junit5;

import java.util.Arrays;
import java.util.List;

public class StudentDao {
    public Student findById(int id) {
        if (id == 3) throw new NoEntityFoundException("Student with id 3 is not allowed.");
        return new Student(id, "Johan", "johan@email.com");
    }

    public List<Student> findAll() {
        return Arrays.asList(
                new Student(1, "Johan", "johan@email.com"),
                new Student(2, "Piet", "Piet@email.com"));
    }
}
