package entity;

import baseclass.InputInformation;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements InputInformation, Serializable {
    private static int idSubject = 100;

    public static final String DC = "Đại Cương";
    public static final String CSN = "Cơ Sở Ngành";
    public static final String CN = "Chuyen Ngành";

    private int id;
    private String nameSuject;
    private Double nTeachingUnit;
    private String typeSubject;


    public Subject() {

    }

    public Subject(int id, String nameSuject, Double nTeachingUnit, String typeSubject) {
        this.id = id;
        this.nameSuject = nameSuject;
        this.nTeachingUnit = nTeachingUnit;
        this.typeSubject = typeSubject;
    }

    public static int getIdSubject() {
        return idSubject;
    }

    public static void setIdSubject(int idSubject) {
        Subject.idSubject = idSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSuject() {
        return nameSuject;
    }

    public void setNameSuject(String nameSuject) {
        this.nameSuject = nameSuject;
    }

    public Double getnTeachingUnit() {
        return nTeachingUnit;
    }

    public void setnTeachingUnit(Double nTeachingUnit) {
        this.nTeachingUnit = nTeachingUnit;
    }

    public String getTypeSubject() {
        return typeSubject;
    }

    public void setTypeSubject(String typeSubject) {
        this.typeSubject = typeSubject;
    }

    @Override
    public void InputInformation() {
        id = idSubject++;
        System.out.println("Nhập tên môn: ");
        nameSuject = new Scanner(System.in).nextLine();
        System.out.println("Số đơn vị học trình ");
        nTeachingUnit = new Scanner(System.in).nextDouble();
        System.out.println("Nhâp loại môn: ");
        typeSubject();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", nameSuject='" + nameSuject + '\'' +
                ", nTeachingUnit=" + nTeachingUnit +
                ", typeSubject='" + typeSubject + '\'' +
                '}';
    }

    public void typeSubject() {
        int s = 0;
        do {
            System.out.println("1. Đại cương");
            System.out.println("2. Cơ sở chuyên ngành");
            System.out.println("3. Chuyên ngành");
            try {
                Scanner scanner = new Scanner(System.in);
                s = scanner.nextInt();
                if (s <= 3 && s >= 1) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Mời Nhập lại:");
            }
        } while (true);
        switch (s) {
            case 1:
                this.typeSubject = Subject.DC;
                break;
            case 2:
                this.typeSubject = Subject.CSN;
                break;
            case 3:
                this.typeSubject = Subject.CN;
                break;
        }
    }

}
