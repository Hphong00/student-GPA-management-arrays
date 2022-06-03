package service;

import entity.Student;
import main.Main;

import java.io.*;
import java.util.Scanner;

public class StudentService {
    public static String STUDENT_FILE = "student.dat";

    public static Student inputListStudent() throws IOException {
        Student student = null;
        do {
            int numberStudent = -1;
            try {
                System.out.println("Nhâp số sinh viên: ");
                numberStudent = new Scanner(System.in).nextInt();
                for (int i = 0; i < numberStudent; i++) {
                    student = new Student();
                    student.InputInformation();
                    addStudentToArray(student);
                }
                Main.initializeData.writeToFile(Main.students,STUDENT_FILE);
                Main.initializeData.readDataFromFile(STUDENT_FILE);
                if (student != null) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        return student;
    }

    public static void addStudentToArray(Student student) throws IOException {
        for (int i = 0; i < Main.students.length; i++) {
            if (Main.students[i] == null) {
                Main.students[i] = student;
                break;
            }
        }
    }

    public static void showStudentFromArray() {
        for (int i = 0; i < Main.students.length; i++) {
            if (Main.students[i]!=null) {
                System.out.println(Main.students[i]);
            }
        }
    }
    public static boolean checkStudentInArray(){
        for (int i = 0; i < Main.students.length; i++) {
            if(Main.students[i]!=null){
                return true;
            }
        }
        return false;
    }
}
