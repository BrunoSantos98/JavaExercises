package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> lista = new ArrayList<>();

        System.out.print("Enter file path: ");
        String path = sc.nextLine();
        //path = "/code/JavaExercises-master/FileExercise/FileExercise/src/file";

        try(BufferedReader br = new BufferedReader(new FileReader(path + "/prices.csv"))){
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                lista.add(new Product(name,price,quantity));
                line = br.readLine();

            }

            boolean mkdirSucces = new File(path + "/out").mkdir();
            System.out.println("A pasta out foi criada? " + mkdirSucces);

            if(mkdirSucces){
                BufferedWriter bw = new BufferedWriter(new FileWriter(path + "/out/summary.csv"));
                for(Product product : lista){
                    bw.write(product.getName() + "," + product.total());
                    bw.newLine();
                }
                bw.close();
            }

        }catch (IOException e){
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }finally {
            sc.close();
        }

    }
}