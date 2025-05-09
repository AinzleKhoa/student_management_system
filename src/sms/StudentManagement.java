package sms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lê Anh Khoa - CE190449
 */
public class StudentManagement implements Menu {

    private List<Student> students = new ArrayList<>(); // Danh sách chứa các đối tượng Student

    // Phương thức thêm sinh viên vào danh sách
    @Override
    public void addStudent(Student student) {
        students.add(student); // Thêm đối tượng Student vào danh sách students
    }

    // Phương thức xóa sinh viên dựa trên số báo danh (roll number)
    @Override
    public boolean deleteStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollnumber().equals(rollNumber)) { // Nếu tìm thấy sinh viên với số báo danh khớp
                students.remove(student); // Xóa sinh viên khỏi danh sách
                return true; // Trả về true nếu xóa thành công
            }
        }
        return false; // Trả về false nếu không tìm thấy sinh viên với số báo danh khớp
    }

    @Override
    // Phương thức tìm sinh viên dựa trên số báo danh (roll number)
    public Student findStudentByRollNumber(String rollNumber) {
        for (Student student : students) {
            if (student.getRollnumber().equals(rollNumber)) { // Nếu tìm thấy sinh viên với số báo danh khớp
                return student; // Trả về đối tượng Student tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy sinh viên với số báo danh khớp
    }

    // Phương thức lấy tất cả sinh viên
    @Override
    public List<Student> getAllStudents() {
        return students; // Trả về danh sách tất cả sinh viên
    }

    //Kiểm tra xem ROllNUmber có bị trùng lặp hay không, vi rollnumber là cơ sở để search cho phần update/delete/search student.
    public boolean isRollNumberDuplicate(String rollNumber) {
        for (Student student : students) {
            if (student.getRollnumber().equals(rollNumber)) {
                return true; // Trả về true nếu số báo danh đã tồn tại
            }
        }
        return false; // Trả về false nếu số báo danh không tồn tại
    }

    @Override
    public void loadStudents() {
        // Phương thức loadStudents được sử dụng để tải danh sách sinh viên từ một tệp lưu trữ.

        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveStudents() {
        // Phương thức saveStudents được sử dụng để lưu danh sách sinh viên vào một tệp lưu trữ.

        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
