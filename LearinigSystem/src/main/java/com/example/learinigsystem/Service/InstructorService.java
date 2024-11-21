package com.example.learinigsystem.Service;

import com.example.learinigsystem.Model.Course;
import com.example.learinigsystem.Model.Instructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class InstructorService {

    private ArrayList<Instructor> instructors = new ArrayList<>();
    //Start CRUD
    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }
    public boolean updateInstructor(String id, Instructor instructor) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getEmail().equals(id)) {
                instructors.set(i, instructor);
                return true;
            }
        }
        return false;
    }
    public boolean deleteInstructor(String id) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getEmail().equals(id)) {
                instructors.remove(i);
                return true;
            }
        }
        return false;
    }
    //End CRUD

    public Instructor searchInstructor(String name) {
        for (Instructor instructor : instructors) {
            if (instructor.getName().equalsIgnoreCase(name)) {
                return instructor;
            }
        }
        return null;
    }
    public boolean goOnLeave(String ID, int leaveDay) {
        Instructor onleave = null;
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId().equals(ID)) {
                onleave = instructors.get(i);
                break;
            }
        }
        if (onleave != null) {
            if (!onleave.isLeave() && onleave.getAnnualLeave() >= leaveDay) {
                onleave.setLeave(true);

                onleave.setAnnualLeave(onleave.getAnnualLeave() - leaveDay);
                return true;
            }
        }
        return false;
    }
    public boolean updateCourse(String instructorID, Course course) {

        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId().equals(instructorID)) {
                instructors.get(i).setCourse(course);
                return true;
            }
        }return false;

    }

}