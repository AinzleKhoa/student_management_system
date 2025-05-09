package sms;

import java.io.Serializable;

/**
 * @author Lê Anh Khoa - CE190449
 */
public abstract class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String birth;

    public Person(String name, int age, String gender, String phoneNumber, String email, String birth) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birth = birth;
    }

    // Getters and setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    // Abstract method that must be implemented by subclasses
    public abstract String displayInfo();
}
