package com.knoldus.jdbc.dao;

import com.knoldus.jdbc.ConnectionProvider;
import com.knoldus.jdbc.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductDataAccess {
    public static boolean insertProductToDB(Product p){
        boolean value=false;
         try {
             //jDbc connection
             Connection con = ConnectionProvider.createConnection();
             String query ="insert into product_details(Pid,Pname,Pprice) values(?,?,?)";
             //prepared statement
             PreparedStatement pstmt=con.prepareStatement(query);
             //set the value of parameter
             pstmt.setInt(1,p.getPid());
             pstmt.setString(2,p.getPname());
             pstmt.setDouble(3,p.getPrice());
             //execute
             pstmt.executeUpdate();
             value=true;
         }catch(Exception e){
           e.printStackTrace();
         }
         return value;
    }

    public static boolean deleteProduct(int pro_id) {
        boolean value=false;
        try {
            //jDbc connection
            Connection con = ConnectionProvider.createConnection();
            String query ="delete from product_details where Pid=?";
            //prepared statement
            PreparedStatement pstmt=con.prepareStatement(query);
            //set the value of parameter
            pstmt.setInt(1,pro_id);
            //execute
            pstmt.executeUpdate();
            value=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }

    public static void displayAllProduct() {
        boolean value=false;
        try {
            //jDbc connection
            Connection con = ConnectionProvider.createConnection();
            String query ="select * from product_details;";
            //statement
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble("Pprice");
                System.out.print("ID:  "+id+" ");
                System.out.print("NAME:  "+name+" ");
                System.out.printf("PRICE:  "+price+" ");
                System.out.println("\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
