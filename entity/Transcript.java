package entity;

import entity.detail.SubjectDetail;
import main.Main;

import java.io.Serializable;
import java.util.Arrays;

public class Transcript implements Serializable {
    private Student student;
    private SubjectDetail[] subjectDetails;

    public Transcript(Student student, SubjectDetail[] subjectDetails) {
        this.student = student;
        this.subjectDetails = subjectDetails;
    }

    public Transcript() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectDetail[] getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(SubjectDetail[] subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "student=" + student +
                ", subjectDetails=" + Arrays.toString(subjectDetails) +
                '}';
    }
}
