
package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private String semster;
    private List<Course> listCourse = new ArrayList<>();

    public Student(String studentId, String studentName, String semster) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.semster = semster;
    }
    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
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

    public List<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentName=" + studentName + ", semster=" + semster + ", listCourse=" + listCourse + '}';
    }

}
