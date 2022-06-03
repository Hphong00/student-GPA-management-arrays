package entity;

import baseclass.Person;
import baseclass.InputInformation;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements InputInformation, Serializable{
    private static int idStudent = 10000;

    private int id;
    private String nameClass;

    public Student(String fullName, String address, String phone, int id, String nameClass) {
        super(fullName, address, phone);
        this.id = id;
        this.nameClass = nameClass;
    }

    public Student(int id, String nameClass) {
        this.id = id;
        this.nameClass = nameClass;
    }

    public Student() {

    }

    public static int getIdStudent() {
        return idStudent;
    }

    public static void setIdStudent(int idStudent) {
        Student.idStudent = idStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id + " " +
                super.toString() +
                ", nameClass='" + nameClass + '\'' +
                '}';
    }

    @Override
    public void InputInformation() {
        this.id = idStudent++;
        super.InputInformation();
        System.out.println("Nhập tên lớp sinh viên:");
        nameClass = new Scanner(System.in).nextLine();
    }
}
