package org.otopark.dao;

import org.otopark.model.Customer;
import org.otopark.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDao {

        private Connection connection;
        public CustomerDao() throws SQLException {
                this.connection= DatabaseConnection.getInstance().getConnection();
        }
        public boolean createCustomer (Customer customer){
                String query  = "INSERT INTO customers (name, surname, email, phone_number, age) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                        stmt.setString(1, customer.getName());
                        stmt.setString(2, customer.getSurname());
                        stmt.setString(3, customer.getEmail());
                        stmt.setString(4, customer.getPhoneNumber());
                        stmt.setInt(5, customer.getAge());

                        int rowsInserted = stmt.executeUpdate();
                        return rowsInserted > 0;
                } catch (SQLException e) {
                        e.printStackTrace();
                        return false;
                }
        }



}
