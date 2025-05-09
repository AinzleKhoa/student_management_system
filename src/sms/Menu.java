package sms;

import java.util.List;

/**
 * @author Lê Anh Khoa - CE190449
 */
public interface Menu {

    void addStudent(Student student);

    boolean deleteStudent(String rollNumber);

    Student findStudentByRollNumber(String rollNumber);

    public boolean isRollNumberDuplicate(String rollNumber);

    List<Student> getAllStudents();

    void loadStudents();

    void saveStudents();
}
