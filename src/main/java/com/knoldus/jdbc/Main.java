package com.knoldus.jdbc;

import com.knoldus.jdbc.dao.ProductDataAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("welcome to product management app");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("press 1 to add product");
            System.out.println("press 2 to delete product");
            System.out.println("press 3 to display product");
            System.out.println("press 4 to close the app");
            int choice =Integer.parseInt(br.readLine());
            if(choice==1){
                //add product
                System.out.println("Enter Product Id");
                int Id =Integer.parseInt(br.readLine());
                System.out.println("Enter Product name");
                String name = br.readLine();
                System.out.println("Enter Product price");
                double price=Double.parseDouble(br.readLine());
                // creating object of product class
                Product p = new Product(Id,name,price);
               boolean ans= ProductDataAccess.insertProductToDB(p);
               if(ans){
                   System.out.println("product is added successfuly");
               }else {
                   System.out.println("sorry to inform you! but something is wrong. Please try again...");
               }
            }else if(choice==2){
                //delete product
                System.out.println("Enter Product Id to delete");
                int pro_Id= Integer.parseInt(br.readLine());
                boolean del=ProductDataAccess.deleteProduct(pro_Id);
                if(del){
                    System.out.println("product is deleted successfully!");
                }else {
                    System.out.println("sorry to inform you! but something is wrong. Please try again...");
                }
            }else if(choice==3){
                //display product
                ProductDataAccess.displayAllProduct();
            }else if(choice==4){
                //exit
                break;
            }else{

            }
        }
        System.out.println("Thanks for using our application!");
    }
}
