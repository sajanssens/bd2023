package unittesting.slides.junit5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class NewAssertionsInJUnit5 {

    private StudentDao studentDao = new StudentDao();

    @Test
    void testAssertAllExecutesAllTheAssertions() {
        Student s = new Student(1, "Johan", "johan@email.com");
        Student s1 = studentDao.findById(1);

        assertAll("Student details are not equal.",
                () -> assertEquals(s.getName(), s1.getName()),
                () -> assertEquals(s.getEmail(), s1.getEmail()));
    }

    @Test
    void testAssertArrayEquals() {
        Student[] expected = new Student[]{
                new Student(1, "Johan", "johan@email.com"),
                new Student(2, "Piet", "Piet@email.com")};

        Object[] students = studentDao.findAll().toArray();

        assertArrayEquals(expected, students);
    }

    @Test
    void testAssertIterableEquals() {
        List<Student> expected = Arrays.asList(
                new Student(1, "Johan", "johan@email.com"),
                new Student(2, "Piet", "Piet@email.com"));

        List<Student> students = studentDao.findAll();

        assertIterableEquals(expected, students);
    }

    @Test
    void testAssertLinesMatch() {
        String regexpEmail = "\\w+@\\w+\\.\\w+";
        List<String> expected = Arrays.asList(regexpEmail, regexpEmail);

        List<String> actual = studentDao.findAll().stream()
                .map(Student::getEmail)
                .collect(Collectors.toList());

        assertLinesMatch(expected, actual);
    }

    // Junit 4 behaviour:
    // @Test(expected=EntityNotFoundException.class)
    // The JUnit 5 way:
    @Test
    void whenFindByIdIsCalledWithNonExistingIdThenItShouldThrowANoEntityFoundException() {
        int idDoesNotExist = 3;
        NoEntityFoundException e =
                assertThrows(NoEntityFoundException.class,
                        () -> studentDao.findById(idDoesNotExist),
                        "Student with id " + idDoesNotExist + " should not exist.");
        assertEquals(e.getMessage(), "Student with id 3 is not allowed.");
    }

    @Test
    void testAssumptions() {
        List<Student> students = studentDao.findAll();
        Student student = new Student(1, "Johan", "johan@email.com");

        assumeFalse(students == null);
        assumeTrue(students.size() < 0);

        assumingThat(students.contains(student),
                () -> assertTrue(students.size() > 1));
    }

}

