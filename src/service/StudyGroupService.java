package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import javax.xml.stream.events.DTD;
import java.util.ArrayList;
import java.util.List;

public class StudyGroupService {
    private List<Student> studentList;
    private Teacher teacher;
    public StudyGroupService(List<Student> studentList, Teacher teacher) {
        this.studentList = new ArrayList<>();
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
    private int getFreeId(Type type) {
        boolean istStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user: studentList) {
            if (user instanceof Teacher && !istStudent) {
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if (user instanceof Student && istStudent) {
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }
    public void createStudyGroup (String firstName, String lastName, String middleName, Type type) {
        int id = getFreeId(type);
        if (type == type.STUDENT) {
            Student student = new Student(firstName, lastName, middleName, id);
            studentList.add(student);
        }
        if (type == type.TEACHER) {
            this.teacher = new Teacher(firstName, lastName, middleName, id);
        }
    }
}
