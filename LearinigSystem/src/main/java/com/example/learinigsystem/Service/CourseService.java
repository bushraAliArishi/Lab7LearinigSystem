package com.example.learinigsystem.Service;

import com.example.learinigsystem.Model.Course;
import com.example.learinigsystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();
    //Start CRUD
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course) {
        courses.add(course);
    }
    public boolean updateCourse(String id, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(id)) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCourse(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(id)) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
    //End CRUD

    public Course searchCourse(String ID) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(ID)) {
                return course;
            }
        }
        return null;
    }
    public ArrayList<Course> getCoursesByLevel(int level) {
        ArrayList<Course> filteredCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseLevel() == level) {
                filteredCourses.add(course);
            }
        }
        return filteredCourses;
    }
    public boolean updatecapacity(String courseID,int addvalue){
        Course course = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(courseID)) {
                course=courses.get(i);
                break;
            }
        }
        if (course != null) {
            course.setCapacity(course.getCapacity()+addvalue);
            return true;
        }
        return false;
    }
}