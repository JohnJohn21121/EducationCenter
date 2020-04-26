package com.johnjohn21121.Lists;

import com.johnjohn21121.People.AuxiliarTeacher;

import java.util.ArrayList;

public class AuxiliarTeacherList {

    public ArrayList<AuxiliarTeacher> auxiliarTeachers = new ArrayList<AuxiliarTeacher>();

    public  boolean addNewTeacher(AuxiliarTeacher auxiliarTeacher){
        if (teacherExists(auxiliarTeacher)) {
            System.out.println((String.format("Id %s is already Registered. Registration Failed",
                    auxiliarTeacher.getTeacherId())));
            return false;
        }
        System.out.println(String.format("Teacher %s %s, Coaching hours : %s , is registered with Id %s , successfully",
                auxiliarTeacher.getTeacherName(),
                auxiliarTeacher.getTeacherLastName(),
                auxiliarTeacher.getCoachingHours(),
                auxiliarTeacher.getTeacherId()));
        auxiliarTeachers.add(auxiliarTeacher);
        return true;
    }

    public void removeTeacher(int id) {
        AuxiliarTeacher existingTeacher = findTeacher(id);
        if (existingTeacher == null) {
            System.out.println("Teacher with id "+ id +" not Found");
            return;
        }
        if (removeTeacher(existingTeacher)){
            System.out.println(String.format("Teacher %s %s with Id: %s , was succesfully deleted.",
                    existingTeacher.getTeacherName(),
                    existingTeacher.getTeacherLastName(),
                    existingTeacher.getTeacherId()));
        }else {
            System.out.println("Error Deleting The Teacher.");
        }
    }

    private boolean removeTeacher(AuxiliarTeacher titularTeacher){
        if (!teacherExists(titularTeacher)){
            System.out.println(String.format("Id %s with the Name: %s %s was not found",
                    titularTeacher.getTeacherId(),
                    titularTeacher.getTeacherName(),
                    titularTeacher.getTeacherLastName()));
            return false;
        }
        this.auxiliarTeachers.remove(findTeacherIndexByTeacherId(titularTeacher));
        System.out.println(titularTeacher.getTeacherName() + " was Deleted from the List.");
        return true;
    }

    public boolean teacherExists(AuxiliarTeacher auxiliarTeacher){
        return findTeacherIndexByTeacherId(auxiliarTeacher.getTeacherId())>=0;
    }

    private int findTeacherIndexByTeacherId(AuxiliarTeacher titularTeacher){
        return this.auxiliarTeachers.indexOf(titularTeacher);
    }

    private int findTeacherIndexByTeacherId(int teacherId){
        for (int i = 0; i< auxiliarTeachers.size(); i++){
            AuxiliarTeacher titularTeacher = auxiliarTeachers.get(i);
            if (titularTeacher.getTeacherId() == teacherId){
                return i;
            }
        }
        return -1;
    }

    public boolean updateTeacherName(AuxiliarTeacher titularTeacher, AuxiliarTeacher updatedTeacher){
        if (teacherExists(titularTeacher)){
            System.out.println(String.format("Teacher with Id: %s was not Found.",titularTeacher.getTeacherId()));
            return false;
        }
        int foundPosition = findTeacherIndexByTeacherId(titularTeacher);
        this.auxiliarTeachers.set(foundPosition,updatedTeacher);
        System.out.println(String.format("Teacher with Id: %s, had it´s name replaced with %s %s",
                titularTeacher.getTeacherId(),
                updatedTeacher.getTeacherName(),
                updatedTeacher.getTeacherLastName()));
        return true;
    }

    public String findTeacher(AuxiliarTeacher auxiliarTeacher){
        if (teacherExists(auxiliarTeacher)){
            return String.format("%s %s, Coaching Hours : %s .",
                    auxiliarTeacher.getTeacherName(),
                    auxiliarTeacher.getTeacherLastName(),
                    auxiliarTeacher.getCoachingHours());
        }
        return null;
    }

    public AuxiliarTeacher findTeacher(int teacherId){
        int position = findTeacherIndexByTeacherId(teacherId);
        if (position>=0){
            return this.auxiliarTeachers.get(position);
        }
        return null;
    }

    public void printTeacherList(){
        StringBuilder sb = new StringBuilder();
        sb.append("The Teacher list is : \n");
        for (AuxiliarTeacher titularTeacher : auxiliarTeachers) {
            sb.append("Id: ").append(titularTeacher.getTeacherId())
                    .append(". ")
                    .append(titularTeacher.getTeacherName())
                    .append(" ")
                    .append(titularTeacher.getTeacherLastName())
                    .append(" , Coaching Hours : ")
                    .append(titularTeacher.getCoachingHours())
                    .append("\n");
        }
        System.out.println(sb);
    }
}
