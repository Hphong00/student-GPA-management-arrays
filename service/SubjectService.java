package service;

import entity.Student;
import entity.Subject;
import main.Main;

import java.io.*;
import java.util.Scanner;

public class SubjectService {
    public static String SUBJECT_FILE = "subject.dat";

    public static Subject inputListSubject() throws IOException {
        Subject subject = null;
        do {
            int numberSubject = -1;
            try {
                System.out.println("Nhâp số môn: ");
                numberSubject = new Scanner(System.in).nextInt();
                for (int i = 0; i < numberSubject; i++) {
                    subject = new Subject();
                    subject.InputInformation();
                    addSubjectToArray(subject);
                }
                Main.initializeData.writeToFile(Main.subjects,SUBJECT_FILE);
                if (subject != null) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        return subject;
    }

    public static void addSubjectToArray(Subject subject) throws IOException {
        for (int i = 0; i < Main.subjects.length; i++) {
            if (Main.subjects[i] == null) {
                Main.subjects[i] = subject;
                break;
            }
        }
    }

    public static void showSubjectFromArray() {
        for (int i = 0; i < Main.subjects.length; i++) {
            if (Main.subjects[i]!=null) {
                System.out.println(Main.subjects[i]);
            }
        }
    }
    public static boolean checkSubjectInArray(){
        for (int i = 0; i < Main.subjects.length; i++) {
            if(Main.subjects[i] != null){
                return true;
            }
        }
        return false;
    }
}
