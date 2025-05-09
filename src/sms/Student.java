package sms;

import java.io.Serializable;

/**
 * @author Lê Anh Khoa - CE190449
 */
public class Student extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String major;
    private String rollnumber;
    private String semester;
    private String rank;

    public Student(String major, String rollnumber, String semester, String rank, String name, int age, String gender, String phoneNumber, String email, String birth) {
        super(name, age, gender, phoneNumber, email, birth);
        this.major = major;
        this.rollnumber = rollnumber;
        this.semester = semester;
        this.rank = rank;
    }

    public String getMajor() {
        return major;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public String getSemester() {
        return semester;
    }

    public String getRank() {
        return rank;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String displayInfo() {
        return "Name: " + getName() + "\n"
                + "Age: " + getAge() + "\n"
                + "Gender: " + getGender() + "\n"
                + "Phone Number: " + getPhoneNumber() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Birth Date: " + getBirth() + "\n"
                + "Major: " + major + "\n"
                + "Roll Number: " + rollnumber + "\n"
                + "Semester: " + semester + "\n"
                + "Rank: " + rank + "\n";
    }
}
