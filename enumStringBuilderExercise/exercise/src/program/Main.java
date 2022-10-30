package program;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter Client Data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = sc.next();
        Date  birthDate = fmt1.parse(date);

        Client client = new Client(name,email,birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String statusReceived = sc.next();
        OrderStatus status = OrderStatus.valueOf(statusReceived);
        Order pedido = new Order(new Date() , status, client);
        System.out.print("How many items to this order? ");
        int qtd = sc.nextInt();

        for(int i =  0; i < qtd; i++){
            sc.nextLine();
            System.out.println("Enter #"  + (i+1) + " item data:");
            System.out.print("Product Name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();

            Product produto = new Product(productName,price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem item = new OrderItem(quantity,price,produto);
            pedido.addItem(item);
        }

        System.out.println("");

        System.out.println(pedido.toString());

        sc.close();

    }
}