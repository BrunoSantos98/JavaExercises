package program;

import entities.Client;
import entities.Order;
import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter Client Data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = sc.next();
        Date  birthDate = (Date) fmt1.parse(date);

        Client c1 = new Client(name,email,birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String statusReceived = sc.next();
        OrderStatus status = OrderStatus.valueOf(statusReceived);
        Order pedido = new Order(LocalDateTime.now() , status);
        System.out.print("How many items to this order? ");
        int qtd = sc.nextInt();

        for(int i =  0; i < qtd; i++){
            sc.nextLine();
            System.out.println("Enter #"  + (i+1) + " item data:");
            System.out.print("Product Name");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
        }

        sc.close();

    }
}