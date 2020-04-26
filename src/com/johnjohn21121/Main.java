package com.johnjohn21121;

import com.johnjohn21121.Exceptions.TeacherNotFoundException;
import com.johnjohn21121.Institution.EducationCenter;
import com.johnjohn21121.People.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws TeacherNotFoundException {
        Scanner scanner = new Scanner(System.in);
        EducationCenter educationCenter = new EducationCenter();
        boolean isProgramRunning = true;
        boolean centerOptionIsActive= true;
        while (isProgramRunning) {
            switch (scanner.nextInt()) {
                case 0:
                    isProgramRunning =false;
                    break;
                case 1:
                    while (centerOptionIsActive) {
                        switch (scanner.nextInt()) {
                            case 0:
                                centerOptionIsActive = false;
                                break;
                            case 1:
                                System.out.println("Please Enter the Student id: ");
                                int studentId = scanner.nextInt();
                                System.out.println("Please Enter the Student Name: ");
                                String studentName = scanner.nextLine();
                                System.out.println("Please Enter the Student Last Name: ");
                                String studentLastName = scanner.nextLine();
                                educationCenter.addStudentToCenter(new Student(studentId,studentName,studentLastName));
                                break;
                            case 2:
                                
                        }
                    }
            }
        }
    }
}