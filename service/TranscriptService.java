package service;

import entity.Student;
import entity.Subject;
import entity.Transcript;
import entity.detail.SubjectDetail;
import main.Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TranscriptService {
    public static final String TRANSCRIPT_DATA_FILE = "transcript.dat";

    public static void inputListTranscript() throws IOException {
        if (!StudentService.checkStudentInArray() && !SubjectService.checkSubjectInArray()) {
            System.out.println("Nhập sinh viên và môn trước.");
            return;
        }
        System.out.println("Nhập số sinh viên: ");
        int number = new Scanner(System.in).nextInt();
        for (int i = 0; i < number; i++) {
            // nhập mã sinh viên
            Student student = inputIdStudent(i);
            if (student == null) {
                System.out.println("Học sinh đã nhập điểm, Mời nhập mã khác");
                break;
            }
            // nhap danh sach mon hoc
            int subjectNumber = inputNumberSubject();
            // số môn
            SubjectDetail[] subjectDetails = new SubjectDetail[subjectNumber];

            creatBoartPoint(subjectDetails, subjectNumber);

            Transcript transcript = new Transcript(student, subjectDetails);

            addTranscriptToArray(transcript);
            Main.initializeData.writeToFile(Main.transcripts, TRANSCRIPT_DATA_FILE);

            showListTranscript();
        }
    }

    private static void addTranscriptToArray(Transcript transcript) {
        for (int i = 0; i < Main.transcripts.length; i++) {
            if (Main.transcripts[i] == null) {
                Main.transcripts[i] = transcript;
                break;
            }
        }
    }

    private static Student inputIdStudent(int number) {
        Student student = null;
        do {
            try {
                System.out.println("Nhâp mã sinh viên: ");
                int idStudent = new Scanner(System.in).nextInt();
                // check đã có sinh viên ghi điểm
                if (checkIdStdent(idStudent)) {
                    break;
                }
                for (int i = 0; i < Main.students.length; i++) {
                    if (Main.subjects[i] != null && Main.students[i].getId() == idStudent) {
                        student = Main.students[i];
                        System.out.println(Main.students[i].toString());
                        break;
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Nhập lại: ");
            }
            if (student != null) {
                break;
            }
        } while (true);
        return student;
    }

    private static void creatBoartPoint(SubjectDetail[] subjectDetails, int subjectNumber) {
        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = inputIdSubject(i);
            int point = inputPoint();
            SubjectDetail subjectDetail = new SubjectDetail(subject, point);
            addSubjecttoAray(subjectDetail, subjectDetails);
        }
    }

    private static int inputNumberSubject() {
        System.out.println("Nhập số môn: ");
        int subjectNumber = -1;
        do {
            try {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber > 0) {
                    break;
                }
            } catch (Exception ex) {

            }
        } while (true);
        return subjectNumber;
    }

    private static Subject inputIdSubject(int number) {
        Subject subject = null;
        do {
            try {
                System.out.println("Nhập mã môn: ");
                int subjectId = new Scanner(System.in).nextInt();
                for (int i = 0; i < Main.subjects.length; i++) {
                    if (Main.subjects[i] != null && Main.subjects[i].getId() == subjectId) {
                        subject = Main.subjects[i];
                        System.out.println(Main.subjects[i]);
                        break;
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.print("Mời nhập lại: ");
            }
            if (subject != null) {
                break;
            }
            System.out.print("Mời nhập lại: ");
        } while (true);
        return subject;
    }

    public static int inputPoint() {
        int point = 0;
        do {
            try {
                System.out.println("Nhập điểm: ");
                point = new Scanner(System.in).nextInt();
                if (point > 0 && point < 10) {
                    System.out.println("Điem: " + point);
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Mời nhập lại");
            }
        } while (true);
        return point;
    }

    private static void addSubjecttoAray(SubjectDetail subjectDetail, SubjectDetail[] subjectDetails) {
        for (int k = 0; k < subjectDetails.length; k++) {
            if (subjectDetails[k] == null) {
                subjectDetails[k] = subjectDetail;
                break;
            }
        }
    }

    public static void showListTranscript() {
        for (int i = 0; i < Main.transcripts.length; i++) {
            if (Main.transcripts[i] != null) {
                System.out.println(Main.transcripts[i]);
            }
        }
    }

    private static boolean checkIdStdent(int idStudent) {
        for (int i = 0; i < Main.transcripts.length; i++) {
            if (Main.transcripts[i] != null && Main.transcripts[i].getStudent().getId() == idStudent) {
                return true;
            }
        }
        return false;
    }

    public static void sort() {
        int nhap = 0;
        do {
            try {
                System.out.println("Mời bạn chọn: ");
                System.out.println("1. Theo Họ tên sinh viên. ");
                System.out.println("2. Theo Tên Môn học. ");
                nhap = new Scanner(System.in).nextInt();
                if (nhap == 1 || nhap == 2) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        if (nhap == 1) {
            for (int i = 0; i < Main.transcripts.length - 1; i++) {
                if (Main.transcripts[i] == null) {
                    continue;
                }
                for (int j = i + 1; j < Main.transcripts.length; j++) {
                    if (Main.transcripts[j] == null) {
                        continue;
                    }
                    if (Main.transcripts[i].getStudent().getFullName().toLowerCase().compareTo(Main.transcripts[j].getStudent().getFullName()) > 0) {
                        Transcript transcript = Main.transcripts[i];
                        Main.transcripts[i] = Main.transcripts[j];
                        Main.transcripts[j] = transcript;
                    }
                }
            }
            showListTranscript();
        } else if (nhap == 2) {
            for (int i = 0; i < Main.transcripts.length - 1; i++) {
                if (Main.transcripts[i] == null) {
                    continue;
                }
                for (int j = i + 1; j < Main.transcripts.length; j++) {
                    if (Main.transcripts[j] == null) {
                        continue;
                    }
                    if (Main.transcripts[i].getSubjectDetails()[i].getSubject().getNameSuject().toLowerCase().compareTo(Main.transcripts[j].getSubjectDetails()[i].getSubject().getNameSuject()) > 0) {
                        Transcript transcript = Main.transcripts[i];
                        Main.transcripts[i] = Main.transcripts[j];
                        Main.transcripts[j] = transcript;
                    }
                }
            }
            showListTranscript();
        }
    }

    public static void totalPoint() {
        double sum = 0;
        int numb = 0;
        for (int i = 0; i < Main.transcripts.length; i++) {
            if (Main.transcripts[i] != null) {
                for (int j = 0; j < Main.transcripts[i].getSubjectDetails().length; j++) {
                    if (Main.transcripts[i].getSubjectDetails()[j] != null) {
                        Double dvh = Main.transcripts[i].getSubjectDetails()[j].getSubject().getnTeachingUnit();
                        Double point = Main.transcripts[i].getSubjectDetails()[j].getPoint();
                        sum += dvh * point;
                        numb++;
                    }
                }
                sum = sum / numb;
                System.out.print("Điểm tổng kết sinh viên: " + Main.transcripts[i].getStudent().getId());
                System.out.println(" là " + sum);
            }
        }
    }
}
