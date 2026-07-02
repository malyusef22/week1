package week1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<Student>();

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n ----- Student Management -----");
            System.out.println("1- Add Student");
            System.out.println("2- Add Marks");
            System.out.println("3- Display Students");
            System.out.println("4- Search Student");
            System.out.println("5- Highest Average");
            System.out.println("6- Exit");

            System.out.print("Choose: ");
            choice = input.nextInt();

            if (choice == 1) {

                input.nextLine();

                System.out.print("ID: ");
                String id = input.nextLine();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).id.equals(id))
                        found = true;
                }

                if (found) {
                    System.out.println("ID already exists.");
                    continue;
                }

                System.out.print("Name: ");
                String name = input.nextLine();

                if (name.equals("")) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }

                System.out.print("Age: ");
                int age = input.nextInt();

                if (age <= 0) {
                    System.out.println("Invalid age.");
                    continue;
                }

                Student s = new Student(id, name, age);
                students.add(s);

                System.out.println("Student Added.");

            }

            else if (choice == 2) {

                input.nextLine();

                System.out.print("Enter Student ID: ");
                String id = input.nextLine();

                Student student = null;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).id.equals(id))
                        student = students.get(i);
                }

                if (student == null) {
                    System.out.println("Student Not Found.");
                    continue;
                }

                System.out.print("How many marks? ");
                int n = input.nextInt();

                for (int i = 1; i <= n; i++) {

                    System.out.print("Enter mark " + i + ": ");
                    int mark = input.nextInt();

                    while (mark < 0 || mark > 100) {
                        System.out.print("Enter mark again: ");
                        mark = input.nextInt();
                    }

                    student.addMark(mark);
                }

            }

            else if (choice == 3) {

                if (students.size() == 0) {
                    System.out.println("No Students.");
                }

                for (int i = 0; i < students.size(); i++) {
                    students.get(i).display();
                }

            }

            else if (choice == 4) {

                input.nextLine();

                System.out.print("Enter ID: ");
                String id = input.nextLine();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).id.equals(id)) {

                        students.get(i).display();
                        found = true;

                    }

                }

                if (!found)
                    System.out.println("Student Not Found.");

            }

            else if (choice == 5) {

                if (students.size() == 0) {
                    System.out.println("No Students.");
                    continue;
                }

                Student top = students.get(0);

                for (int i = 1; i < students.size(); i++) {

                    if (students.get(i).getAverage() > top.getAverage()) {
                        top = students.get(i);
                    }

                }

                System.out.println("Highest Average Student:");
                top.display();

            }

            else if (choice == 6) {

                System.out.println("Good Bye");

            }

            else {

                System.out.println("Wrong Choice");

            }

        }

        input.close();

    }

}