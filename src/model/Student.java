
package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String studentName;
    private String semster;
    private List<Course> courseName = new ArrayList<>();

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemster() {
        return semster;
    }

    public void setSemster(String semster) {
        this.semster = semster;
    }

    public List<Course> getCourseName() {
        return courseName;
    }

    public void setCourseName(List<Course> courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentName=" + studentName + ", semster=" + semster + ", courseName=" + courseName + '}';
    }
}
