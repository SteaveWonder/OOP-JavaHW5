package controller;

import model.*;
import service.DataService;
import view.StudentView;
import view.TeacherView;

import java.util.List;

public class Controller {
    private final DataService dataService = new DataService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();

    public void createStudent(String firstName, String lastName, String middleName){
        dataService.create(firstName, lastName, middleName, Type.STUDENT);
    }

    public void getAllStudents() {
        List<User> userList = dataService.getAllStudents();
        for (User user: userList) {
            studentView.printOnConsole((Student) user);
        }
    }
    public void createTeacher (String firstName, String lastName, String middleName) {
        dataService.create(firstName, lastName, middleName, Type.TEACHER);
    }
    public void getAllTeacher() {
        List<User> userList = dataService.getAllTeacher();
        for (User user: userList) {
            teacherView.printOnConsole((Teacher) user);
        }
    }
    public void createStudyGroup(List<Student> studentList, Teacher teacher) {
        if (studentList != null) {
            StudyGroup studyGroup = new StudyGroup(studentList, teacher);
            for (Student student : studentList) {
                studyGroup.addStudent(student);
            }
            studyGroup.addTeacher(teacher);
        }
    }
    public void getAllStudyGroup() {
        List<User> studentList = dataService.getAllStudents();
        for (User user : studentList) {
            studentView.printOnConsole((Student) user);
        }
        List<User> teacherList = dataService.getAllTeacher();
        for (User user : teacherList) {
            teacherView.printOnConsole((Teacher) user);
        }
    }

}
