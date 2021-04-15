package model;

import model.enums.CourseName;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private CourseName name;
    private int lessonsCount;
    private List<Student> students = new ArrayList<>();

    public Course(CourseName name, int lessonsCount) {
        this.name = name;
        this.lessonsCount = lessonsCount;
    }

    public CourseName getName() {
        return name;
    }

    public int getLessonsCount() {
        return lessonsCount;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
