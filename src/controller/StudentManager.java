
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
        Course newCourse = new Course(crId, crName);
        listCourse.add(newCourse);
    }
    
    public void addStudent() {
        String stName = val.getString(">Enter student name: ");
        String stId = val.getString(">Enter student Id: ");
        if(isContainID(stId)) {
            sout
        }
        
        String stSemster = val.getString(">Enter semster: ");
        Student newSt = new Student(stId, stName, stSemster);
        
        do{
            System.out.println("Select course:");
            for (int i = 0; i < listCourse.size(); i++) {
                System.out.println(i +"- "+ listCourse.get(i));
            }
            int crChoice = val.getInt(">Your course: ");
            
            if( newSt.getListCourse().contains(listCourse.get(crChoice)) ) {     //check TH tồn tại 2 khóa học giống nhau 
                System.out.println(">>Course already exist! Select again!!");                                                                        //trong cùng 1 kỳ học
            } else {
                newSt.getListCourse().add(listCourse.get(crChoice));    //add course correct to list
                boolean continueLoop = val.checkInputYN( "Do you want to continue select course(Y/N): ");    //continueLoop == false >>> stop
                if(continueLoop == false) {
                    System.out.println("===============================================");
                    listStudent.add(newSt);
                    break;      //stopLoop
                }
            }
        }while(true);
        
    }
    
    public boolean isContainID(String checkId) {
        for (Student student : listStudent) {
            if(student.getStudentId().equalsIgnoreCase(checkId)) {
                return true;
            }
        }
        return false;
    }
    
}
