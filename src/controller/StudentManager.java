
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
        if(listCourse.isEmpty()) {
            System.out.println("Sorry we don't have any course at this time!");
        } else {
            String stName = val.getString(">Enter student name: ");
            String stId = val.getString(">Enter student Id: ");
            String stSemester = val.getString(">Enter Semester: ");
            if(isContainIDAndSemester(stId, stSemester)) {  //trùng id và semster mới lỗi
                System.out.println(">>Student already exist!!");
            } else {
                Student newSt = new Student(stId, stName, stSemester);
                selectCourse(newSt);
            }  
        } 
    }
    
    public boolean isContainIDAndSemester(String checkId, String checkSemester) {
        for (Student student : listStudent) {
            if( student.getStudentId().equalsIgnoreCase(checkId) ) {
                if( student.getSemester().equalsIgnoreCase(checkSemester) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void selectCourse(Student newStudent) {
        do {
            System.out.println("Select course:");
            System.out.println("(-1)--Exit! ");
            for (int i = 0; i < listCourse.size(); i++) {
                System.out.println(">> "+i+ "- " + listCourse.get(i).getCourseName());
            }
            int crChoice = val.inputIntMinMax(">Your course: ", -1, listCourse.size() - 1);   //nhận giá trị từ -1 <= x <= size()-1

            if (crChoice == -1) {
                System.out.println("===============================================");
                listStudent.add(newStudent);
                break;      //stopLoop
            } else if (newStudent.getListCourse().contains(listCourse.get(crChoice))) {     //check TH tồn tại 2 khóa học giống nhau 
                System.out.println(">>Course already exist! Select again!!");         //trong cùng 1 kì học                                                               //trong cùng 1 kỳ học
            } else {
                newStudent.getListCourse().add(listCourse.get(crChoice));    //add course correct to list
                boolean continueLoop = val.checkInputYN("Do you want to continue select course(Y/N): ");    //continueLoop == false >>> stop
                if (continueLoop == false) {
                    System.out.println("===============================================");
                    listStudent.add(newStudent);
                    break;      //stopLoop
                }
            }
        } while (true);
    }
    
    public List<Student> findStudentsByName(String searchStudent) {
        List<Student> results = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().toLowerCase().contains(searchStudent.toLowerCase())) {     //có chứa string nhập vào
                results.add(student);
            }
        }
        return results;
    }
    
    public Student findStudentsById(String searchId) {
        for (Student student : listStudent) {
            if (student.getStudentId().equalsIgnoreCase(searchId)) {     
                return student;
            }
        }
        return null;
    }
    
    public void findAndSearch() {
        String searchTerm = val.getString(">Enter name student to find: ");
        List<Student> searchResults = findStudentsByName(searchTerm);
        if (searchResults.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            // Sắp xếp theo tên
            Collections.sort(searchResults, Comparator.comparing(student -> student.getStudentName()));

            // Hiển thị kết quả
            System.out.println("Results:");
            for (Student student : searchResults) {
                System.out.print("Student Name: " + student.getStudentName() +
                                   ", Semester: " + student.getSemester() +
                                   ", Course Name: "); // cần điều chỉnh để in hợp lý
                printCourse(student.getListCourse());
                System.out.println();
            }
        }
    }
    
    public void removeSt(Student rmSt) {        //chưa dùng
        for (Student student : listStudent) {
            if(student.equals(rmSt)) {
                listStudent.remove(student);
                break;
            }
        }
    }
    
    public void printCourse(List<Course> listCr) {
        for (Course course : listCr) {
            System.out.print(course.getCourseName() + ", ");
        }
    }
    
    public void updateStudent() {
        String searchTerm = val.getString(">Enter Id student to find: ");
        Student result = findStudentsById(searchTerm);
        if (result == null) {
            System.out.println("No matching students found.");
        } else {
            boolean deleteOrUp = val.checkInputYN("Do you want to Delete(Y) or Update(N) (Y/N): ");
            if(deleteOrUp == true) {
                listStudent.remove(result);      ///////
            } else {
                String stId = result.getStudentId();
                listStudent.remove(result);          //loại bỏ data cũ
                do{
                    String stName = val.getString(">Enter student name: ");
                    String stSemester = val.getString(">Enter Semester: ");
                    if(isContainIDAndSemester(stId, stSemester)) {  //trùng id và semster mới lỗi
                        System.out.println(">>Student already exist!! Enter again!");
                    } else {
                        Student newSt = new Student(stId, stName, stSemester);
                        selectCourse(newSt);
                        break;
                    }
                }while (true);
            }     
        }
    }
    
    public void report() {
        Map<String, Integer> reportData = new HashMap<>();
        if (listStudent.isEmpty()) {
            System.out.println("Empty list!!!");
        } else {
            for (Student student : listStudent) {
                String idSt = student.getStudentId();
                String nameSt = student.getStudentName();
                for (Course course : student.getListCourse()) {
                    String courseName = course.getCourseName();
                    if (reportData.containsKey(courseName + ";" + nameSt + ";" + idSt)) {
                        reportData.put(courseName + ";" + nameSt + ";" + idSt, (reportData.get(courseName + ";" + nameSt + ";" + idSt) + 1));
                    } else {
                        reportData.put(courseName + ";" + nameSt + ";" + idSt, 1);
                    }
                }
            }

            System.out.println("Report:");
            TreeMap<String, Integer> treeMap = new TreeMap<>(reportData);
            for (Map.Entry<String, Integer> student : treeMap.entrySet()) {
                String key = student.getKey();
                Integer value = student.getValue();

                String[] name = key.split(";");
                String courseName = name[0];
                String studentName = name[1];
                String studentId = name[2];

                System.out.println(studentId + " | " + studentName + " | " + courseName + " | " + value);
            }
        }
    }
    
}
