package com.johnjohn21121.Lists;

import com.johnjohn21121.People.TitularTeacher;

import java.util.ArrayList;

public class TitularTeacherList {

    public ArrayList<TitularTeacher> titularTeachers = new ArrayList<TitularTeacher>();

    public  boolean addNewTeacher(TitularTeacher titularTeacher){
        if (teacherExists(titularTeacher)) {
            System.out.println((String.format("Id %s is already Registered. Registration Failed",
                    titularTeacher.getTeacherId())));
            return false;
        }
        System.out.println(String.format("Teacher %s %s, speciality : %s , is registered with Id %s , successfully",
                titularTeacher.getTeacherName(),
                titularTeacher.getTeacherLastName(),
                titularTeacher.getSpeciality(),
                titularTeacher.getTeacherId()));
        titularTeachers.add(titularTeacher);
        return true;
    }

    public void removeTeacher(int id) {
        TitularTeacher existingTeacher = findTeacher(id);
        if (existingTeacher == null) {
            System.out.println("Teacher with id "+ id +" not Found");
            return;
        }
        if (removeTeacher(existingTeacher)){
            System.out.println(String.format("Teacher %s %s with Id: %s , Speciality: %s , was succesfully deleted.",
                    existingTeacher.getTeacherName(),
                    existingTeacher.getTeacherLastName(),
                    existingTeacher.getTeacherId(),
                    existingTeacher.getSpeciality()));
        }else {
            System.out.println("Error Deleting The Teacher.");
        }
    }

    private boolean removeTeacher(TitularTeacher titularTeacher){
        if (!teacherExists(titularTeacher)){
            System.out.println(String.format("Id %s with the Name: %s %s was not found",
                    titularTeacher.getTeacherId(),
                    titularTeacher.getTeacherName(),
                    titularTeacher.getTeacherLastName()));
            return false;
        }
        this.titularTeachers.remove(findTeacherIndexByTeacherId(titularTeacher));
        System.out.println(titularTeacher.getTeacherName() + " was Deleted from the List.");
        return true;
    }

    public boolean teacherExists(TitularTeacher titularTeacher){
        return findTeacherIndexByTeacherId(titularTeacher.getTeacherId())>=0;
    }

    private int findTeacherIndexByTeacherId(TitularTeacher titularTeacher){
        return this.titularTeachers.indexOf(titularTeacher);
    }

    private int findTeacherIndexByTeacherId(int teacherId){
        for (int i = 0; i< titularTeachers.size(); i++){
            TitularTeacher titularTeacher = titularTeachers.get(i);
            if (titularTeacher.getTeacherId()==teacherId){
                return i;
            }
        }
        return -1;
    }

    public boolean updateTeacherName(TitularTeacher titularTeacher, TitularTeacher updatedTeacher){
        if (teacherExists(titularTeacher)){
            System.out.println(String.format("Teacher with Id: %s was not Found.",titularTeacher.getTeacherId()));
            return false;
        }
        int foundPosition = findTeacherIndexByTeacherId(titularTeacher);
        this.titularTeachers.set(foundPosition,updatedTeacher);
        System.out.println(String.format("Teacher with Id: %s, had it´s name replaced with %s %s",
                titularTeacher.getTeacherId(),
                updatedTeacher.getTeacherName(),
                updatedTeacher.getTeacherLastName()));
        return true;
    }

    public String findTeacher(TitularTeacher titularTeacher){
        if (teacherExists(titularTeacher)){
            return String.format("%s %s, Speciality : %s .",
                    titularTeacher.getTeacherName(),
                    titularTeacher.getTeacherLastName(),
                    titularTeacher.getSpeciality());
        }
        return null;
    }

    public TitularTeacher findTeacher(int teacherId){
        int position = findTeacherIndexByTeacherId(teacherId);
        if (position>=0){
            return this.titularTeachers.get(position);
        }
        return null;
    }

    public void printTeacherList(){
        StringBuilder sb = new StringBuilder();
        sb.append("The Teacher list is : \n");
        for (TitularTeacher titularTeacher : titularTeachers) {
            sb.append("Id: ").append(titularTeacher.getTeacherId())
                    .append(". ")
                    .append(titularTeacher.getTeacherName())
                    .append(" ")
                    .append(titularTeacher.getTeacherLastName())
                    .append(" , Speciality : ")
                    .append(titularTeacher.getSpeciality())
                    .append("\n");
        }
        System.out.println(sb);
    }
}
