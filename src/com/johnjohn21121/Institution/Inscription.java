package com.johnjohn21121.Institution;

import com.johnjohn21121.People.Student;

import java.time.Instant;

public class Inscription {

    private Student student;
    private Course course;
    private Instant inscriptionDate;

    public Inscription() {
    }

    public Inscription(Student student, Course course, Instant inscriptionDate) {
        this.student = student;
        this.course = course;
        this.inscriptionDate = inscriptionDate;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Instant getInscriptionDate() {
        return inscriptionDate;
    }
}