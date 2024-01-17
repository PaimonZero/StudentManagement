
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Student;
import view.Validation;

public class StudentManager {
    List<Student> listStudent = new ArrayList<>();
    List<Course> listCourse = new ArrayList<>();
    Validation val = new Validation();
    
    public void addCourse() {
        String crName = val.getString(">Enter course name: ");
        String crId = val.getString(">Enter course Id: ");
        Course newCourse = new Course();
        
    }
            
            
}
