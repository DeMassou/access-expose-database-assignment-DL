package com.example.accessexposedatabaseassignmentdl;

import com.chinook.connection.ConnectionManager;
import com.dataaccess.models.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.util.ArrayList;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Connection conn = ConnectionManager.getInstance().getConnection();

        ConnectionManager connectionManager = new ConnectionManager();
        ArrayList<Customer> customers = connectionManager.selectAllCustomers();
        printCustomers(customers);
    }

    public static void printCustomers(ArrayList<Customer> customers) {
        if(customers.size() != 0) {
            for(Customer c : customers) {
                System.out.println(c.getCustomerId());
                System.out.println(c.getFirstName());
                System.out.println(c.getLastName());
                System.out.println(c.getPhone());
                System.out.println(c.getEmail());
            }
        } else {
            System.out.println("No customers found!");
        }
    }

}
