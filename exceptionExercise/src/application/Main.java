package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Initial Balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.print("Withdraw Limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account conta = new Account(number,name,initialBalance,withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();
            conta.withdraw(amount);
        }catch(DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }

        sc.close();
    }
}