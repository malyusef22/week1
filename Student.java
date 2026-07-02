package week1;

import java.util.ArrayList;

public class Student {

    String id;
    String name;
    int age;
    ArrayList<Integer> marks;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        marks = new ArrayList<Integer>();
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double getAverage() {

        if (marks.size() == 0) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < marks.size(); i++) {
            sum = sum + marks.get(i);
        }

        return (double) sum / marks.size();
    }

    public String getGrade() {

        double avg = getAverage();

        if (avg >= 90)
            return "A";
        else if (avg >= 80)
            return "B";
        else if (avg >= 70)
            return "C";
        else if (avg >= 60)
            return "D";
        else
            return "F";
    }

    public void display() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number of Marks: " + marks.size());
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println("----------------------");

    }

}