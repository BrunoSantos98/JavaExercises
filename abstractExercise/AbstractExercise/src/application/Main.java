package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        List<TaxPayer> contribuintes = new ArrayList<TaxPayer>(n);

        for(int i = 1; i <= n; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char resp = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anuel Income: ");
            Double anualIncome = sc.nextDouble();

            if(resp == 'i'){
                System.out.print("Health expenditures: ");
                double healthExp = sc.nextDouble();
                contribuintes.add(new Individual(name,anualIncome,healthExp));
            }else{
                System.out.print("Number of employees: ");
                Integer numEmployees = sc.nextInt();
                contribuintes.add(new Company(name,anualIncome,numEmployees));
            }

        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        Double totalSum = 0.0;
        for(TaxPayer list : contribuintes){
            totalSum += list.tax();
            System.out.println(
                    list.getName() + ": $" + String.format("%.2f",list.tax())
            );
        }
        System.out.println();
        System.out.println("Total Taxes: $" + totalSum);

        sc.close();
    }
}