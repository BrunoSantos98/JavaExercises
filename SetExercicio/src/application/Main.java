package application;

import entities.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Student> students = new HashSet<>();

        System.out.print("Howw many students for course A? ");
        int quantity = sc.nextInt();
        addStudent(students,quantity);

        System.out.print("Howw many students for course B? ");
        quantity = sc.nextInt();
        addStudent(students,quantity);

        System.out.print("Howw many students for course C? ");
        quantity = sc.nextInt();
        addStudent(students,quantity);

        System.out.println("Total Students: " + students.size());

        sc.close();
    }

    public static void addStudent(Set<Student> setStudent,int qtd){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < qtd; i++){
            setStudent.add(new Student(sc.nextInt()));
        }
    }
}