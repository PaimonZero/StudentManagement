
package model;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentId;
    private String studentName;
    private String semster;
    private Map<Course, Integer> courseName = new HashMap<>();

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

    public Map<Course, Integer> getCourseName() {
        return courseName;
    }

    public void setCourseName(Map<Course, Integer> courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentName=" + studentName + ", semster=" + semster + ", courseName=" + courseName + '}';
    }

}
