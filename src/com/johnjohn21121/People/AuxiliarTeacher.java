package com.johnjohn21121.People;

public class AuxiliarTeacher {

    private int teacherId;
    private String teacherName;
    private String teacherLastName;
    private int coachingHours;


    public AuxiliarTeacher() {
    }

    public AuxiliarTeacher(int teacherId, String teacherName, String teacherLastName, int coachingHours) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherLastName = teacherLastName;
        this.coachingHours = coachingHours;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public int getCoachingHours() {
        return coachingHours;
    }

    public void setCoachingHours(int coachingHours) {
        this.coachingHours = coachingHours;
    }

}
