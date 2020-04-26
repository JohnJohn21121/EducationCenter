package com.johnjohn21121.People;

public class Student {

    private int studentId;
    private String studentName;
    private String studentLastName;

    public Student() {

    }

    public Student(int studentId, String studentName, String studentLastName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
}
