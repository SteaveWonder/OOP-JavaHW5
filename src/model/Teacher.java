package model;

public class Teacher extends User {

    private int teacherId;

    public Teacher(String firstName, String lastName, String middleName, int teacherId) {
        super(firstName, lastName, middleName);
        this.teacherId = teacherId;
    }


    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName = " + super.getFirstName() + '\'' +
                ", lastName = " + super.getLastName() + '\'' +
                ", middleName = " + super.getMiddleName() + '\'' +
                '}';
    }
}
