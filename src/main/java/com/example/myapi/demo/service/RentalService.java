package com.example.myapi.demo.service;

import com.example.myapi.demo.model.Rental;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.example.myapi.demo.Constants.*;

public class RentalService {
    private Connection _connection;
    private List<Rental> rentaltList;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public RentalService() throws SQLException {
        _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Rental addRental(Rental rental) throws SQLException {

        String sql = "INSERT INTO rental ( car_id, client_id, rental_date, return_date) VALUES (?,?,?,?)";
        PreparedStatement statement = _connection.prepareStatement(sql);
        statement.setInt(1, rental.getCarId());
        statement.setInt(2, rental.getClientId());
        statement.setString(3, rental.getRentalDate().format(formatter));
        statement.setString(4, rental.getReturnDate().format(formatter));
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) return rental;
        else return null;
    }

    public List<Rental> getAllRentalsList() throws SQLException {
        rentaltList = new ArrayList<>();
        String sql = "SELECT * FROM rental";
        PreparedStatement statement = _connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("rental_id");
            int carId = resultSet.getInt("car_id");
            int clientId = resultSet.getInt("client_id");
            LocalDate rentalDate = LocalDate.parse(resultSet.getString("rental_date"),formatter);
            LocalDate returnDate = LocalDate.parse(resultSet.getString("return_date"),formatter);
            rentaltList.add(new Rental(id, carId, clientId, rentalDate, returnDate));
        }
        return rentaltList;
    }

    public Rental getRentalById(int id) throws SQLException {
        String sql = "SELECT * FROM rental WHERE rental_id = ?";
        PreparedStatement statement = _connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        boolean hasResults = resultSet.next();
        if(!hasResults) return null;
        int rentalId = resultSet.getInt("rental_id");
        int carId = resultSet.getInt("car_id");
        int clientId = resultSet.getInt("client_id");
        LocalDate rentalDate = LocalDate.parse(resultSet.getString("rental_date"),formatter);
        LocalDate returnDate = LocalDate.parse(resultSet.getString("return_date"),formatter);
        return (new Rental(rentalId, carId, clientId, rentalDate, returnDate));
    }

    public boolean updateRental(int id, LocalDate returnDate) throws SQLException {
        if(getRentalById(id) == null) return false;
        String updateSql = "UPDATE rental SET return_date = ? WHERE rental_id = ?";
        PreparedStatement statement = _connection.prepareStatement(updateSql);
        statement.setString(1, returnDate.format(formatter));
        statement.setInt(2, id);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) return true;
        else return false;
    }

    public boolean deleteRental(int id) throws SQLException {
        String deleteSql = "DELETE FROM rental WHERE rental_id = ?";
        PreparedStatement statement = _connection.prepareStatement(deleteSql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        return (rowsDeleted > 0) ? true : false;
    }

}
