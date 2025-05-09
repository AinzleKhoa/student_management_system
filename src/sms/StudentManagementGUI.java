package sms;

import sms.gui.MenuGUI;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 * @author Lê Anh Khoa - CE190449
 */
public class StudentManagementGUI extends JFrame {

    // Biến sinh viên để quản lý danh sách sinh viên
    private StudentManagement studentManagement;

    // Constructor: Khởi tạo StudentManagementGUI
    public StudentManagementGUI() {
        studentManagement = new StudentManagement();
        studentManagement.loadStudents();
        new MenuGUI(this);
    }

    /*
    ****************************************************************************FUNCTION: ADD STUDENT********************************************************************************************************************************************************
     */
    public void addStudent() {
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NAME++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JTextField nameField = new JTextField();
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++AGE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JTextField ageField = new JTextField();
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++GENDER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++PHONENUMBER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JTextField phoneNumberField = new JTextField();
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++EMAIL++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JTextField emailLocalPartField = new JTextField();
        JRadioButton gmailButton = new JRadioButton("@gmail.com");
        JRadioButton fptuButton = new JRadioButton("@fpt.edu.vn");
        ButtonGroup emailGroup = new ButtonGroup();
        emailGroup.add(gmailButton);
        emailGroup.add(fptuButton);
        JPanel emailPanel = new JPanel();
        emailPanel.add(gmailButton);
        emailPanel.add(fptuButton);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++DATEBIRTH++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JFormattedTextField birthField = null;
        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');
            birthField = new JFormattedTextField(dateFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ROLLNUMBER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JTextField rollNumberField = new JTextField();
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++SEMESTER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JTextField majorField = new JTextField();
        JTextField semesterCourseField = new JTextField();
        JRadioButton englishButton = new JRadioButton("English Semester");
        JRadioButton majorButton = new JRadioButton("Major Semester");
        ButtonGroup semesterGroup = new ButtonGroup();
        semesterGroup.add(englishButton);
        semesterGroup.add(majorButton);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++RANK++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel semesterPanel = new JPanel();
        semesterPanel.add(englishButton);
        semesterPanel.add(majorButton);
        JRadioButton poorButton = new JRadioButton("Poor");
        JRadioButton averageButton = new JRadioButton("Average");
        JRadioButton goodButton = new JRadioButton("Good");
        JRadioButton excellentButton = new JRadioButton("Excellent");
        ButtonGroup rankGroup = new ButtonGroup();
        rankGroup.add(poorButton);
        rankGroup.add(averageButton);
        rankGroup.add(goodButton);
        rankGroup.add(excellentButton);
        JPanel rankPanel = new JPanel();
        rankPanel.add(poorButton);
        rankPanel.add(averageButton);
        rankPanel.add(goodButton);
        rankPanel.add(excellentButton);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++KHAI BÁO FIELD VỚI CÁC BIẾN TRÊN++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Object[] fields = {
            "Name:", nameField,
            "Age:", ageField,
            "Gender:", genderPanel,
            "Phone Number:", phoneNumberField,
            "Email:", emailLocalPartField, emailPanel,
            "Major:", majorField,
            "Birth Date (DD/MM/YYYY):", birthField,
            "Roll Number:", rollNumberField,
            "Semester:", semesterPanel, semesterCourseField,
            "Rank:", rankPanel
        };

        int option;
        boolean validInput = false;

        while (!validInput) {
            option = JOptionPane.showConfirmDialog(this, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();
                String phoneNumber = phoneNumberField.getText().trim();
                String emailLocalPart = emailLocalPartField.getText().trim();
                String major = majorField.getText().trim();
                String birth = birthField.getText().trim();
                String rollNumber = rollNumberField.getText().trim();
                String semesterCourseText = semesterCourseField.getText().trim();

                // Một code phòng được lập ra để tránh trường hợp người dùng nhập thiếu/để trống một ô nào đó.
                if (name.isEmpty() || ageText.isEmpty() || (!maleButton.isSelected() && !femaleButton.isSelected())
                        || phoneNumber.isEmpty() || emailLocalPart.isEmpty() || (!gmailButton.isSelected() && !fptuButton.isSelected())
                        || birth.isEmpty() || rollNumber.isEmpty() || major.isEmpty() || semesterCourseText.isEmpty()
                        || (!poorButton.isSelected() && !averageButton.isSelected() && !goodButton.isSelected() && !excellentButton.isSelected())) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                //=================================================================AGE=================================================================
                int age;
                try {
                    age = Integer.parseInt(ageText);
                    if (age < 1 || age > 100) {
                        throw new NumberFormatException("Age out of range");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid age between 1 and 100.", "Invalid Age", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                //=================================================================GENDER=================================================================
                String gender = maleButton.isSelected() ? "Male" : "Female";
                if (!phoneNumber.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid 10-digit phone number.", "Invalid Phone Number", JOptionPane.WARNING_MESSAGE);
                    continue;
                    //=================================================================BIRTHDATE=================================================================
                }
                if (!birth.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid birth date in the format DD/MM/YYYY.", "Invalid Birth Date", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                String[] birthParts = birth.split("/");
                int day = Integer.parseInt(birthParts[0]);
                int month = Integer.parseInt(birthParts[1]);
                int year = Integer.parseInt(birthParts[2]);
                if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid birth date (Date must be 1-31, Month must be 1-12, Year must also be from 1900 onward).", "Invalid Birth Date", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                //=================================================================ROLLNUMBER=================================================================
                if (!rollNumber.matches("[a-zA-Z]{2}\\d{6}")) {
                    JOptionPane.showMessageDialog(this, "Roll number must contain 2 letters followed by 6 digits.", "Invalid Roll Number", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                if (studentManagement.isRollNumberDuplicate(rollNumber)) {
                    JOptionPane.showMessageDialog(this, "Roll number already exists. Please enter a different roll number.", "Duplicate Roll Number", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                //=================================================================RANK=================================================================
                String rank = "";
                if (poorButton.isSelected()) {
                    rank = "Poor";
                } else if (averageButton.isSelected()) {
                    rank = "Average";
                } else if (goodButton.isSelected()) {
                    rank = "Good";
                } else if (excellentButton.isSelected()) {
                    rank = "Excellent";
                }
                //=================================================================EMAIL=================================================================
                String emailDomain = gmailButton.isSelected() ? "@gmail.com" : "@fpt.edu.vn";
                String email = emailLocalPart.replaceAll("\\s+", "") + emailDomain.trim();
                //=================================================================SEMESTER=================================================================
                if (!(englishButton.isSelected() || majorButton.isSelected())) {
                    JOptionPane.showMessageDialog(this, "Please select a semester type.", "Invalid Semester Type", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                String semesterCourseChoosing = englishButton.isSelected() ? "English Semester" : "Major Semester";
                if (!semesterCourseText.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Semester course must be a digit & no space.", "Invalid Semester Course", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                int semesterCourse = Integer.parseInt(semesterCourseText);
                if (englishButton.isSelected() && (semesterCourse < 1 || semesterCourse > 6)) {
                    JOptionPane.showMessageDialog(this, "For English Semester, the course number must be between 1 and 6.", "Invalid Semester Course", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                if (majorButton.isSelected() && (semesterCourse < 1 || semesterCourse > 9)) {
                    JOptionPane.showMessageDialog(this, "For Major Semester, the course number must be between 1 and 9.", "Invalid Semester Course", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                String semester = semesterCourseChoosing + ": " + semesterCourse;
                //=================================================================KẾT THÚC VÀ LƯU VÀO=================================================================
                studentManagement.addStudent(new Student(major, rollNumber, semester, rank, name, age, gender, phoneNumber, email, birth));
                validInput = true;
            } else {
                break;
            }
        }
    }

    /*
    ****************************************************************************FUNCTION: DELETE STUDENT****************************************************************************
     */
    public void deleteStudent() {
        String rollNumber = JOptionPane.showInputDialog(this, "Enter Roll Number to delete:", "Delete Student", JOptionPane.QUESTION_MESSAGE);
        if (rollNumber != null && !rollNumber.trim().isEmpty()) {
            boolean success = studentManagement.deleteStudent(rollNumber);
            if (success) {
                JOptionPane.showMessageDialog(this, "Student deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a roll number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
    }

    /*
    ****************************************************************************FUNCTION: UPDATE STUDENT********************************************************************************************************************************************************
     */
    public void updateStudent() {
        String rollNumber = JOptionPane.showInputDialog(this, "Enter Roll Number to update:", "Update Student", JOptionPane.QUESTION_MESSAGE);
        if (rollNumber != null && !rollNumber.trim().isEmpty()) {
            Student student = studentManagement.findStudentByRollNumber(rollNumber);
            if (student != null) {
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NAME++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JTextField nameField = new JTextField(student.getName());
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++AGE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JTextField ageField = new JTextField(String.valueOf(student.getAge()));
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++PHONENUMBER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JTextField phoneNumberField = new JTextField(student.getPhoneNumber());
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++GENDER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JRadioButton maleButton = new JRadioButton("Male");
                JRadioButton femaleButton = new JRadioButton("Female");
                ButtonGroup genderGroup = new ButtonGroup();
                genderGroup.add(maleButton);
                genderGroup.add(femaleButton);
                JPanel genderPanel = new JPanel();
                genderPanel.add(maleButton);
                genderPanel.add(femaleButton);
                if (student.getGender().equalsIgnoreCase("Male")) {
                    maleButton.setSelected(true);
                } else if (student.getGender().equalsIgnoreCase("Female")) {
                    femaleButton.setSelected(true);
                }
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++EMAIL++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JTextField emailLocalPartField = new JTextField(student.getEmail().split("@")[0].trim());
                JRadioButton gmailButton = new JRadioButton("@gmail.com");
                JRadioButton fptuButton = new JRadioButton("@fpt.edu.vn");
                ButtonGroup emailGroup = new ButtonGroup();
                emailGroup.add(gmailButton);
                emailGroup.add(fptuButton);
                JPanel emailPanel = new JPanel();
                emailPanel.add(gmailButton);
                emailPanel.add(fptuButton);
                if (student.getEmail().endsWith("@gmail.com")) {
                    gmailButton.setSelected(true);
                } else if (student.getEmail().endsWith("@fpt.edu.vn")) {
                    fptuButton.setSelected(true);
                }
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++BIRTHDATE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JFormattedTextField birthField = new JFormattedTextField(student.getBirth());
                try {
                    MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
                    dateFormatter.setPlaceholderCharacter('_');
                    birthField = new JFormattedTextField(dateFormatter);
                    birthField.setText(student.getBirth());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++SEMESTER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JTextField majorField = new JTextField(student.getMajor());
                JTextField semesterCourseField = new JTextField(student.getSemester().split(": ")[1]);
                JRadioButton englishButton = new JRadioButton("English Semester");
                JRadioButton majorButton = new JRadioButton("Major Semester");
                ButtonGroup semesterGroup = new ButtonGroup();
                semesterGroup.add(englishButton);
                semesterGroup.add(majorButton);
                JPanel semesterPanel = new JPanel();
                semesterPanel.add(englishButton);
                semesterPanel.add(majorButton);
                if (student.getSemester().startsWith("English Semester")) {
                    englishButton.setSelected(true);
                } else if (student.getSemester().startsWith("Major Semester")) {
                    majorButton.setSelected(true);
                }
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++RANK++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                JRadioButton poorButton = new JRadioButton("Poor");
                JRadioButton averageButton = new JRadioButton("Average");
                JRadioButton goodButton = new JRadioButton("Good");
                JRadioButton excellentButton = new JRadioButton("Excellent");
                ButtonGroup rankGroup = new ButtonGroup();
                rankGroup.add(poorButton);
                rankGroup.add(averageButton);
                rankGroup.add(goodButton);
                rankGroup.add(excellentButton);
                JPanel rankPanel = new JPanel();
                rankPanel.add(poorButton);
                rankPanel.add(averageButton);
                rankPanel.add(goodButton);
                rankPanel.add(excellentButton);
                if (student.getRank().equalsIgnoreCase("Poor")) {
                    poorButton.setSelected(true);
                } else if (student.getRank().equalsIgnoreCase("Average")) {
                    averageButton.setSelected(true);
                } else if (student.getRank().equalsIgnoreCase("Good")) {
                    goodButton.setSelected(true);
                } else if (student.getRank().equalsIgnoreCase("Excellent")) {
                    excellentButton.setSelected(true);
                }
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++FIELD NƠI KHỞI TẠO CÁC BIẾN TRÊN, NHƯ PHẦN ADDSTUDENT THÔI++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Object[] fields = {
                    "Name:", nameField,
                    "Age:", ageField,
                    "Gender:", genderPanel,
                    "Phone Number:", phoneNumberField,
                    "Email:", emailLocalPartField, emailPanel,
                    "Birth Date (DD/MM/YYYY):", birthField,
                    "Major:", majorField,
                    "Semester:", semesterPanel, semesterCourseField,
                    "Rank:", rankPanel
                };
                //=================================================================QUÁ TRÌNH KIỂM TRA NHƯ CŨ BÊN TRÊN=================================================================
                boolean validInput = false;
                while (!validInput) {
                    int option = JOptionPane.showConfirmDialog(this, fields, "Update Student", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        String name = nameField.getText().trim();
                        String ageText = ageField.getText().trim();
                        String phoneNumber = phoneNumberField.getText().trim();
                        String emailLocalPart = emailLocalPartField.getText().trim();
                        String major = majorField.getText().trim();
                        String birth = birthField.getText().trim();
                        String semesterCourseText = semesterCourseField.getText().trim();

                        if (name.isEmpty() || ageText.isEmpty() || (!maleButton.isSelected() && !femaleButton.isSelected())
                                || phoneNumber.isEmpty() || emailLocalPart.isEmpty() || birth.isEmpty() || major.isEmpty()
                                || semesterCourseText.isEmpty()
                                || (!poorButton.isSelected() && !averageButton.isSelected() && !goodButton.isSelected() && !excellentButton.isSelected())) {
                            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        //=================================================================NAME=================================================================
                        int age;
                        try {
                            age = Integer.parseInt(ageText);
                            if (age < 1 || age > 100) {
                                throw new NumberFormatException("Age out of range");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Please enter a valid age between 1 and 100.", "Invalid Age", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        //=================================================================GENDER=================================================================
                        String gender = maleButton.isSelected() ? "Male" : "Female";
                        if (!phoneNumber.matches("\\d{10}")) {
                            JOptionPane.showMessageDialog(this, "Please enter a valid 10-digit phone number.", "Invalid Phone Number", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        //=================================================================BIRTHDATE=================================================================
                        if (!birth.matches("\\d{2}/\\d{2}/\\d{4}")) {
                            JOptionPane.showMessageDialog(this, "Please enter a valid birth date in the format DD/MM/YYYY.", "Invalid Birth Date", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        String[] birthParts = birth.split("/");
                        int day = Integer.parseInt(birthParts[0]);
                        int month = Integer.parseInt(birthParts[1]);
                        int year = Integer.parseInt(birthParts[2]);
                        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900) {
                            JOptionPane.showMessageDialog(this, "Please enter a valid birth date (Date must be 1-31, Month must be 1-12, Year must also be from 1900 onward).", "Invalid Birth Date", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        //=================================================================RANK=================================================================
                        String rank = "";
                        if (poorButton.isSelected()) {
                            rank = "Poor";
                        } else if (averageButton.isSelected()) {
                            rank = "Average";
                        } else if (goodButton.isSelected()) {
                            rank = "Good";
                        } else if (excellentButton.isSelected()) {
                            rank = "Excellent";
                        }
                        //=================================================================EMAIL=================================================================
                        String emailDomain = gmailButton.isSelected() ? "@gmail.com" : "@fpt.edu.vn";
                        String email = emailLocalPart.replaceAll("\\s+", "") + emailDomain.trim();
                        if (!(englishButton.isSelected() || majorButton.isSelected())) {
                            JOptionPane.showMessageDialog(this, "Please select a semester type.", "Invalid Semester Type", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        //=================================================================SEMESTER=================================================================
                        String semesterCourseChoosing = englishButton.isSelected() ? "English Semester" : "Major Semester";
                        if (!semesterCourseText.matches("\\d+")) {
                            JOptionPane.showMessageDialog(this, "Semester course must be a digit & no space.", "Invalid Semester Course", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        int semesterCourse = Integer.parseInt(semesterCourseText);
                        if (englishButton.isSelected() && (semesterCourse < 1 || semesterCourse > 6)) {
                            JOptionPane.showMessageDialog(this, "For English Semester, the course number must be between 1 and 6.", "Invalid Semester Course", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        if (majorButton.isSelected() && (semesterCourse < 1 || semesterCourse > 9)) {
                            JOptionPane.showMessageDialog(this, "For Major Semester, the course number must be between 1 and 9.", "Invalid Semester Course", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        //=================================================================NẾU TẤT CẢ BIẾN ĐỀU VALID THÌ BẮT ĐẦU UPDATE DỮ LIỆU=================================================================
                        String semester = semesterCourseChoosing + ": " + semesterCourse;
                        student.setName(name);
                        student.setAge(age);
                        student.setGender(gender);
                        student.setPhoneNumber(phoneNumber);
                        student.setEmail(email);
                        student.setBirth(birth);
                        student.setMajor(major);
                        student.setSemester(semester);
                        student.setRank(rank);
                        validInput = true;
                    } else {
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a roll number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
    }

    /*
    ****************************************************************************FUNCTION: SEARCH STUDENT********************************************************************************************************************************************************
     */
    public void searchStudent() {
        String rollNumber = JOptionPane.showInputDialog(this, "Enter Roll Number to search:", "Search Student", JOptionPane.QUESTION_MESSAGE);
        if (rollNumber != null && !rollNumber.trim().isEmpty()) {
            Student student = studentManagement.findStudentByRollNumber(rollNumber);
            if (student != null) {
                JOptionPane.showMessageDialog(this, student.displayInfo(), "Student Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a roll number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
    }

    /*
    ****************************************************************************FUNCTION: DISPLAY ALL STUDENT********************************************************************************************************************************************************
     */
    public void displayAllStudents() {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><table border='1'>");
        html.append("<tr>")
                .append("<th>Roll Number</th>")
                .append("<th>Name</th>")
                .append("<th>Age</th>")
                .append("<th>Gender</th>")
                .append("<th>Phone Number</th>")
                .append("<th>Email</th>")
                .append("<th>Birth Date</th>")
                .append("<th>Major</th>")
                .append("<th>Semester</th>")
                .append("<th>Rank</th>")
                .append("</tr>");

        for (Student student : studentManagement.getAllStudents()) {
            html.append("<tr>")
                    .append("<td>").append(student.getRollnumber()).append("</td>")
                    .append("<td>").append(student.getName()).append("</td>")
                    .append("<td>").append(student.getAge()).append("</td>")
                    .append("<td>").append(student.getGender()).append("</td>")
                    .append("<td>").append(student.getPhoneNumber()).append("</td>")
                    .append("<td>").append(student.getEmail()).append("</td>")
                    .append("<td>").append(student.getBirth()).append("</td>")
                    .append("<td>").append(student.getMajor()).append("</td>")
                    .append("<td>").append(student.getSemester()).append("</td>")
                    .append("<td>").append(student.getRank()).append("</td>")
                    .append("</tr>");
        }

        html.append("</table></body></html>");
        JOptionPane.showMessageDialog(this, new JScrollPane(new JLabel(html.toString())), "All Students", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
    ****************************************************************************FUNCTION: SAVE AND EXIT********************************************************************************************************************************************************
     */
    public void saveAndExit() {
        studentManagement.saveStudents();
        System.exit(0);
    }
}
