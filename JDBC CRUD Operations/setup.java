package com.jdbc;

import java.sql.*;

public class setup {
    public void createDatabase(){

        try{
            String url = "jdbc:mysql://localhost:3306/";     //port no. is optional
            String username="root";
            String password ="Adarsh***";  //Password may be change according to yours

            Connection con = DriverManager.getConnection(url,username,password);
            Statement stm = con.createStatement();
            System.out.println("Connected Successfully");
            String query = "create database collection";
            stm.execute(query);
            System.out.println("Database created successfully ");
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable() {
        try{
            String url = "jdbc:mysql://localhost:3306/company";     //port no is optional
            String username="root";
            String password ="Adarsh***";

            Connection con = DriverManager.getConnection(url,username,password);
            Statement stm = con.createStatement();
            System.out.println("Connected Successfully");
            String query = "create table team (Id int(5) , Name  varchar(20), Email varchar(20) , Salary int(10))";
            stm.execute(query);
            System.out.println("Table created successfully ");
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createData() {
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String db = "collection";
            String username="root";
            String password ="Adarsh***";

            Connection con = DriverManager.getConnection(url+db ,username,password);
            Statement stm = con.createStatement();
            System.out.println("Connected Successfully");
            String query = "Insert into employee (Id , Name , Email , Salary) VALUES(?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,26);
            pstm.setString(2,"Aman");
            pstm.setString(3,"amansh@gmail.com");
            pstm.setInt(4,3000);

            pstm.setInt(1,27);
            pstm.setString(2,"Lalit");
            pstm.setString(3, "Lalit@gmail.com");
            pstm.setInt(4,2000);

            pstm.execute();
            System.out.println("Data Inserted successfully ");
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void readData() {
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String db = "collection";
            String username="root";
            String password ="Adarsh***";

            Connection con = DriverManager.getConnection(url+db ,username,password);
            String query = "Select * from employee";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                System.out.println("Id ="+rs.getInt(1));
                System.out.println("Name ="+rs.getString(2));
                System.out.println("Email ="+rs.getString(3));
                System.out.println("Salary ="+rs.getInt(4));
                System.out.println("\t");
            }

            System.out.println("Table read successfully "+rs);
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateData() {
        try{
            String url = "jdbc:mysql://localhost:3306/";     //port no is optional
            String db = "collection";
            String username="root";
            String password ="Adarsh***";

            Connection con = DriverManager.getConnection(url+db ,username,password);
            Statement stm = con.createStatement();
            System.out.println("Connected Successfully");
            String query = "Update employee set Id = ? where name = ? ";
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(    1,12);
            pstm.setString(2,"Boom");

            pstm.execute();
            System.out.println("Data updated successfully ");
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteData() {

        try{
            String url = "jdbc:mysql://localhost:3306/";     //port no is optional
            String db = "collection";
            String username="root";
            String password ="Adarsh***";

            Connection con = DriverManager.getConnection(url+db ,username,password);
            Statement stm = con.createStatement();
            System.out.println("Connected Successfully");
            String query = "truncate table employee";
            stm.execute(query);
            System.out.println("Table deleted successfully ");
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
