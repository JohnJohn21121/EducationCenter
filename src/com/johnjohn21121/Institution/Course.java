package com.johnjohn21121.Institution;

import com.johnjohn21121.Exceptions.TeacherNotFoundException;
import com.johnjohn21121.People.AuxiliarTeacher;
import com.johnjohn21121.People.Student;
import com.johnjohn21121.People.TitularTeacher;

import java.time.Instant;
import java.util.ArrayList;

public class Course {

    private EducationCenter educationCenter;
    private int courseId;
    private String courseName;
    private String courseEdition;
    private String courseClassRoom;
    private TitularTeacher titularTeacher;
    private AuxiliarTeacher auxiliarTeacher;
    private int courseVacancy;
    private ArrayList<Inscription> inscriptions = new ArrayList<>();

    public Course(EducationCenter educationCenter, int courseId, String courseName, String courseEdition,
                  String courseClassRoom, int courseVacancy) {
        this.educationCenter = educationCenter;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseEdition = courseEdition;
        this.courseClassRoom = courseClassRoom;
        this.courseVacancy = courseVacancy;
    }

    public Course(EducationCenter educationCenter, int courseId, String courseName, String courseEdition,
                  String courseClassRoom, TitularTeacher titularTeacher,
                  AuxiliarTeacher auxiliarTeacher, int courseVacancy) throws TeacherNotFoundException {
        this.educationCenter = educationCenter;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseEdition = courseEdition;
        this.courseClassRoom = courseClassRoom;
        if (educationCenter.titularTeacherIsInCenter(titularTeacher)){
            this.titularTeacher = titularTeacher;
        }else {
            throw new TeacherNotFoundException("Teacher is not in the Center.");
        }
        if (educationCenter.auxiliarTeacherIsInCenter(auxiliarTeacher)) {
            this.auxiliarTeacher = auxiliarTeacher;
        }else {
            throw new TeacherNotFoundException("Teacher is not in the Center");
        }
        this.courseVacancy = courseVacancy;
    }

    public void enrollStudent(Student student) {
        if (inscriptions.size() < courseVacancy) {
            if (educationCenter.studentIsInCenter(student)) {
                Inscription inscription = new Inscription(student,this, Instant.now());
                inscriptions.add(inscription);
                System.out.println(String.format("Student %s %s, enrolled in the course %s.",
                        student.getStudentName(),
                        student.getStudentLastName(),
                        getCourseName()));
            } else
                System.out.println(String.format("Student %s %s, not in Center, student cannot enroll to this course.",
                        student.getStudentName(),
                        student.getStudentLastName()));
        }else
            System.out.println(String.format("Student %s %s, cannot enroll to the course %s, because it´s full",
                    student.getStudentName(),
                    student.getStudentLastName(),
                    getCourseName()));
    }

    public TitularTeacher getTitularTeacher() {
        return titularTeacher;
    }

    public AuxiliarTeacher getAuxiliarTeacher() {
        return auxiliarTeacher;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseEdition() {
        return courseEdition;
    }

    public String getCourseClassRoom() {
        return courseClassRoom;
    }

    public int getCourseVacancy() {
        return courseVacancy;
    }

    public void assignTitularTeacherToCourse(TitularTeacher titularTeacher) {
        this.titularTeacher = titularTeacher;
    }

    public void assignAuxiliarTeacherToCourse(AuxiliarTeacher auxiliarTeacher) {
        this.auxiliarTeacher = auxiliarTeacher;
    }

    public void printEnrolledStudents(){
        StringBuilder sb = new StringBuilder();
        sb.append("The Students enrolled to this course are : \n");
        for (Inscription inscription : inscriptions) {
            sb.append("Id: ").append(inscription.getStudent().getStudentId())
                    .append(". ")
                    .append(inscription.getStudent().getStudentName())
                    .append(" ")
                    .append(inscription.getStudent().getStudentLastName())
                    .append("\n");
        }
        System.out.println(sb);
    }

}

