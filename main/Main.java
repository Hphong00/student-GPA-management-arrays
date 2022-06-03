package main;
import entity.Student;
import entity.Subject;
import entity.Transcript;
import data.InitializeData;
import service.StudentService;
import service.SubjectService;
import service.TranscriptService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Student[] students = new Student[50];
    public static Subject[] subjects = new Subject[50];
    public static Transcript[] transcripts = new Transcript[50];

    public static InitializeData initializeData = new InitializeData();

    public static void main(String[] args) throws IOException {
        sMenu();
        select();
    }
    private static void select() throws IOException {
        boolean cont = true;
        do {
            System.out.print("Mời bạn chọn: ");
            int number = 0;
            try {
                number = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Moi nhap lai: ");
            }
            switch (number) {
                case 1:
                    StudentService.inputListStudent();
                    sMenu();
                    break;
                case 2:
                    StudentService.showStudentFromArray();
                    sMenu();
                    break;
                case 3:
                    SubjectService.inputListSubject();
                    sMenu();
                    break;
                case 4:
                    SubjectService.showSubjectFromArray();
                    sMenu();
                    break;
                case 5:
                    TranscriptService.inputListTranscript();
                    sMenu();
                    break;
                case 6:
                    TranscriptService.showListTranscript();
                    sMenu();
                    break;
                case 7:
                    TranscriptService.sort();
                    sMenu();
                    break;
                case 8:
                    TranscriptService.totalPoint();
                    sMenu();
                    break;
                case 9:
                    cont = false;
            }
        } while (cont);
    }

    private static void sMenu() {
        System.out.println("---Quản lý điểm sinh viên---");
        System.out.println("1. Nhập danh sách sinh viên mới. ");
        System.out.println("2. Xem list sinh viên. ");
        System.out.println("3. Nhập danh sách môn học mới. ");
        System.out.println("4. Xem list môn học. ");
        System.out.println("5. Nhập điểm.");
        System.out.println("6. Nhập điểm.");
        System.out.println("7. Sắp xếp.");
        System.out.println("8. Điểm tổng kết chung cho mỗi học sinh.");
        System.out.println("9. Thoát");
    }
}
