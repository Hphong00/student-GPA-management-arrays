package entity.detail;

import entity.Subject;

import java.io.Serializable;

public class SubjectDetail implements Serializable {
    private Subject subject;
    private double point;

    public SubjectDetail(Subject subject, double point) {
        this.subject = subject;
        this.point = point;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "DetailSubject{" +
                "subject=" + subject +
                ", point=" + point +
                '}';
    }
}
