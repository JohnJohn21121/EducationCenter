package com.johnjohn21121.Lists;

import com.johnjohn21121.People.Student;

import java.util.ArrayList;

public class StudentList {

    public  ArrayList<Student> students = new ArrayList<Student>();

    public  boolean addNewStudent(Student student){
        if (studentExists(student)) {
            System.out.println((String.format("Id %s is already Registered. Registration Failed",
                    student.getStudentId())));
            return false;
        }
        System.out.println(String.format("Student %s %s is registered with Id %s , successfully",
                student.getStudentName(),
                student.getStudentLastName(),
                student.getStudentId()));
        students.add(student);
        return true;
    }

    public void removeStudent(int id) {
        Student existingStudent = findStudentById(id);
        if (existingStudent == null) {
            System.out.println("Student not Found");
            return;
        }
        if (removeStudent(existingStudent)){
            System.out.println(String.format("Student %s %s with Id: %s , was succesfully deleted.",
                    existingStudent.getStudentName(),
                    existingStudent.getStudentLastName(),
                    existingStudent.getStudentId()));
        }else {
            System.out.println("Error Deleting The Student.");
        }
    }

    private boolean removeStudent(Student student) {
        int foundPosition = findStudentIndexByStudentId(student);
        if (foundPosition<0) {
            System.out.println(String.format("Id %s with the Name: %s %s was not found",
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getStudentLastName()));
            return false;
        }
            this.students.remove(findStudentIndexByStudentId(student));
            return true;
    }

    public boolean studentExists(Student student){
        return findStudentIndexByStudentId(student.getStudentId())>=0;
    }

    private int findStudentIndexByStudentId(Student student){
        return this.students.indexOf(student);
    }

    private int findStudentIndexByStudentId(int studentId){
        for (int i = 0; i< students.size(); i++){
        Student student = students.get(i);
        if (student.getStudentId()==studentId){
            return i;
            }
        }
        return -1;
    }

    public boolean updateStudentName(Student oldStudent,Student newStudent){
        if (studentExists(oldStudent)){
            System.out.println(String.format("Student with Id: %s was not Found.",oldStudent.getStudentId()));
            return false;
        }
        int foundPosition = findStudentIndexByStudentId(oldStudent);
        this.students.set(foundPosition,newStudent);
        System.out.println(String.format("Student with Id: %s name was replaced with %s %s",
                oldStudent.getStudentId(),
                newStudent.getStudentName(),
                newStudent.getStudentLastName()));
        return true;
    }

    public String findStudent(Student student){
        if (studentExists(student)){
            return String.format("%s %s", student.getStudentName(), student.getStudentLastName());
        }
        return null;
    }

    public Student findStudentById(int studentId){
        int position = findStudentIndexByStudentId(studentId);
        if (position>=0){
            return this.students.get(position);
        }
        return null;
    }

    public Student findStudentInList(Student student){
        int position = findStudentIndexByStudentId(student.getStudentId());
        if (position>=0){
            return student;
        }
        return null;
    }

    public void printStudentList(){
        StringBuilder sb = new StringBuilder();
        sb.append("The Student list is : \n");
        for (Student student : students) {
            sb.append("Id: ").append(student.getStudentId())
                    .append(". ")
                    .append(student.getStudentName())
                    .append(" ")
                    .append(student.getStudentLastName())
                    .append("\n");
        }
        System.out.println(sb);
    }

}
