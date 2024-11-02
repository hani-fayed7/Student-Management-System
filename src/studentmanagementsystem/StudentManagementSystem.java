/*Done by hani and fouad*/

package studentmanagementsystem;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagementSystem {
    static LinkedList<Student> students = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);
    static int counter = 1;
    
    public static void main(String[] args) {
        System.out.println("************************Welcome to our Student Management System************************");
        while (true) {
            System.out.println("1. Add student" +
                                "\n2. View student" +
                                "\n3. Search student by ID" +
                                "\n4. Remove student by ID" +
                                "\n5. Exit" +
                                "\n****************************************************************************************");
                                
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                viewStudent();
            } else if (choice == 3) {
                searchStudentById();
            } else if (choice == 4){
                removeStudent();
            }
            else {
                break;
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name;
        name = input.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter student Phone Number: ");
        String phoneNumber = scanner.next();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        String ID = year + "000" + counter;
        counter++;
        System.out.println(">> "+ name +"'s ID is: "+ID+" <<");
        System.out.println("****************************************************************************************");
        
        Student student = new Student(name, age, phoneNumber, ID);
        students.add(student);
    }

    public static void viewStudent() {
        int i = 1;
        if(students.isEmpty()){
            ifNoStudentInTheSystem();
        }
        else{
            for (Student student : students) {
                System.out.println("Student name: " + student.name);
                System.out.println("Student age: " + student.age);
                System.out.println("Student phone number: " + student.phoneNumber);
                System.out.println("Student ID: " + student.ID);
                i++;
                if(students.size() > 1 && students.size() > i - 1){
                    System.out.println("********************************************");
                }
            }
            System.out.println("****************************************************************************************");
           
        }
    }


    public static void searchStudentById() {
        if(students.isEmpty()){
            ifNoStudentInTheSystem();
        }
        else{
            System.out.print("Enter student ID: ");
            String enrollmentNumber = scanner.next();

            for (Student student : students) {
                if (student.ID.equals(enrollmentNumber)) {
                    System.out.println(">> Student found! <<");
                    System.out.println("Student Name: " + student.name);
                    System.out.println("         Age: " + student.age);
                    System.out.println("Phone Number: " + student.phoneNumber);
                    System.out.println("          ID: " + student.ID);
                    System.out.println("****************************************************************************************");
                    return;
                }
            }

            System.out.println(">> Student not found! <<");
            System.out.println("****************************************************************************************");
        }
    }
    public static void removeStudent(){
         if(students.isEmpty()){
            ifNoStudentInTheSystem();
        }
         else{
            System.out.print("Enter student ID that you want to remove: ");
            String enrollmentNumber = scanner.next();

            for (Student student : students) {
                if (student.ID.equals(enrollmentNumber)) {
                    students.remove(student);
                    System.out.println(">> Student " +student.name+" removed successfully <<");
                    System.out.println("****************************************************************************************");
                    return;
                }
            }


            System.out.println(">> Note: No student with such ID available! <<");
            System.out.println("****************************************************************************************");
         }
    }

    public static void ifNoStudentInTheSystem(){
        if(students.isEmpty()){
            System.out.println("NOTE: No Students are added to the system yet!");
            System.out.println("****************************************************************************************");
        }
    }
}
