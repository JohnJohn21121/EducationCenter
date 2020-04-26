package com.johnjohn21121.Institution;

import com.johnjohn21121.Lists.AuxiliarTeacherList;
import com.johnjohn21121.Lists.StudentList;
import com.johnjohn21121.Lists.TitularTeacherList;
import com.johnjohn21121.People.AuxiliarTeacher;
import com.johnjohn21121.People.Student;
import com.johnjohn21121.People.TitularTeacher;

public class EducationCenter {

    private StudentList studentList = new StudentList() ;
    private TitularTeacherList titularTeacherList = new TitularTeacherList();
    private AuxiliarTeacherList auxiliarTeacherList = new AuxiliarTeacherList();

    public void addStudentToCenter(Student student){
        studentList.addNewStudent(student);
    }

    public void removeStudentFromCenter(int studentId){
        studentList.removeStudent(studentId);
    }

    public void addTitularTeacherToCenter(TitularTeacher titularTeacher){
        titularTeacherList.addNewTeacher(titularTeacher);
    }

    public void removeTitularTeacherFromCenter(int titularTeacherId){
        titularTeacherList.removeTeacher(titularTeacherId);
    }

    public void addAuxiliarTeacherToCenter(AuxiliarTeacher auxiliarTeacher){
        auxiliarTeacherList.addNewTeacher(auxiliarTeacher);
    }

    public void removeAuxiliarTeacherFromCenter(int auxiliarTeacherId){
        auxiliarTeacherList.removeTeacher(auxiliarTeacherId);
    }

    public boolean studentIsInCenter(Student student){
        return studentList.studentExists(student);
    }

    public boolean titularTeacherIsInCenter(TitularTeacher titularTeacher){
        return titularTeacherList.teacherExists(titularTeacher);
    }

    public boolean auxiliarTeacherIsInCenter(AuxiliarTeacher auxiliarTeacher){
        return auxiliarTeacherList.teacherExists(auxiliarTeacher);
    }

    public void printStudentsInCenter(){
        studentList.printStudentList();
    }

    public void printTitularTeachersInCenter(){
        titularTeacherList.printTeacherList();
    }

    public void printAuxiliarTeachersInCenter(){
        auxiliarTeacherList.printTeacherList();
    }

}
