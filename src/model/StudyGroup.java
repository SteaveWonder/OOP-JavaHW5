package model;

import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    private List<Student> studentList;
    private Teacher teacher;
    public StudyGroup(List<Student> studentList, Teacher teacher) {
        this.studentList = studentList;
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "teacher = " + teacher +
                " ,studentList = " + studentList +
                '}';
    }
    public void addStudent(Student student) {
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(student);
    }
    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
