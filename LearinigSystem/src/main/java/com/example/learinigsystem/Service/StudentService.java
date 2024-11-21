package com.example.learinigsystem.Service;

import com.example.learinigsystem.Model.Course;
import com.example.learinigsystem.Model.Instructor;
import com.example.learinigsystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();
    //Start CRUD
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public boolean updateStudent(String id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getEmail().equals(id)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getEmail().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    //End CRUD

    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
    public ArrayList<Student> getStudentsByLevel(int level) {
        ArrayList<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getLevel() == level) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
    public boolean studentGraduate(String studentID){
        Student graduat = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(studentID)) {
                graduat = students.get(i);
                break;
            }
        }
        if (graduat != null) {
            if (!graduat.isGraduate()) {
                graduat.setGraduate(true);
                return true;
            }
        }
        return false;
    }



}