package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();
        //path: /code/JavaExercises-master/expressoesFuncionais/src/file/employees.csv
        System.out.print("Enter salary: ");
        double testSalary = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> list = new ArrayList<>();
            String line = br.readLine();

            while(line != null){

                String[] fields = line.split(",");
                String name = fields[0];
                String email = fields[1];
                Double salary = Double.parseDouble(fields[2]);
                list.add(new Employee(name,email,salary));
                line = br.readLine();

            }

            System.out.println();
            System.out.println("Email of people whose salary is more than $2000.00: ");
            list.stream().filter(e -> e.getSalary() > testSalary)
                    .map(e -> e.getEmail())
                    .sorted((e1,e2) -> e1.toLowerCase().compareTo(e2))
                    .forEach(System.out::println);

            System.out.println();
            System.out.print("Sum of salary of people whose name starts with 'M': ");
            Double sum = list.stream().filter(e -> e.getName().charAt(0) == 'M')
                    .map(e -> e.getSalary())
                    .reduce(0.0,(x,y) -> x+y);
            System.out.println("$ " + sum);

        }catch(IOException e){
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        sc.close();
    }
}