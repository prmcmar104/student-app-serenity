package com.studentapp.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay
 */
@Getter
public class StudentPojo {

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public static StudentPojo getStudentPojo(String firstName, String lastName, String email,
                                             String programme, List<String> courses) {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courses);
        return studentPojo;
    }

    public static StudentPojo getStudentPojoForPatchMethod(String email) {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail(email);
        return studentPojo;
    }

    public static List<String> courseList(String course1, String course2){
        List<String> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        return courseList;
    }
}
