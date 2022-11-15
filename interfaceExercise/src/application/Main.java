package application;

import entities.Contract;
import entities.Installment;
import services.ContractServices;
import services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Data (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(sc.next(),fmt);
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(number,date,contractValue);

        System.out.print("Entre com o numero de parcelas: ");
        int installmentNumber = sc.nextInt();

        ContractServices services = new ContractServices(new PaypalService());

        services.processContract(contract,installmentNumber);

        System.out.println("Parcelas: ");
        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }


        sc.close();
    }
}