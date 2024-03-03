package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    private List<User> userList;
    public DataService() {
        this.userList = new ArrayList<>();
    }
    public List<User> getUserList() {
        return userList;
    }



    public void create(String firstName, String lastName, String middleName, Type type){
        int id = getFreeId(type);
        if (Type.STUDENT == type){
            Student student = new Student(firstName, lastName, middleName, id);
            userList.add(student);
        }
        if (Type.TEACHER == type){
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userList.add(teacher);
        }
    }

    public User getUserById(Type type, int id){
        boolean itsStudent = Type.STUDENT == type;
        //User currentUser = null;
        for (User user: userList) {
            if (user instanceof  Teacher && ((Teacher) user).getTeacherId() == id) {  // instanceof - принадлежит классу
                return user;
            }
            if (user instanceof Student && ((Student) user).getStudentId() == id) {
                return user;
            }
        }
        return null;
    }



    public List<User> getAllStudents() {
        List<User> studentList = new ArrayList<>();
        for (User user: userList) {
            if (user instanceof Student) {
                studentList.add(user);
            }
        }
        return studentList;
    }

    private int getFreeId(Type type){
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user: userList) {
            if (user instanceof Teacher && !itsStudent) {  // instanceof - принадлежит классу
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if (user instanceof Student && itsStudent) {
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }
    public List<User> getAllTeacher() {
        List<User> teacherList = new ArrayList<>();
        for (User user : userList) {
            if(user instanceof Teacher) {
                teacherList.add(user);
            }
        }
        return teacherList;
    }
}
