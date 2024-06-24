package com.example.myapi.demo.service;
import com.example.myapi.demo.model.Car;

import static com.example.myapi.demo.Constants.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarService {

    private Connection _connection;
    private List<Car> carList;
    public CarService() throws SQLException {
        _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //carList = new ArrayList<>();
    }

    public List<Car> getAllCarsList() throws SQLException {
        carList = new ArrayList<>();
        String sql = "SELECT * FROM car";
        PreparedStatement statement = _connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("car_id");
            String make = resultSet.getString("make");
            String model = resultSet.getString("model");
            int year = resultSet.getInt("year");
            boolean available = resultSet.getBoolean("available");
            carList.add(new Car(id, make, model, year, available));
        }
        return carList;
    }

    public String addCar(Car car) throws SQLException {
        String sql = "INSERT INTO car ( make, model, year, available) VALUES (?,?,?,?)";
        PreparedStatement statement = _connection.prepareStatement(sql);
        statement.setString(1, car.getMake());
        statement.setString(2, car.getModel());
        statement.setInt(3, car.getYear());
        statement.setBoolean(4, car.isAvailable());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) return "Pridėta";
        else return "Nepridėta";
    }

    public Car getCarById(int id) throws SQLException {
        String sql = "SELECT * FROM car WHERE car_id = ?";
        PreparedStatement statement = _connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        boolean hasResults = resultSet.next();
        if(!hasResults) return null;
        int car_id = resultSet.getInt("car_id");
        String make = resultSet.getString("make");
        String model = resultSet.getString("model");
        int year = resultSet.getInt("year");
        boolean available = resultSet.getBoolean("available");
        return (new Car(car_id, make, model, year, available));
    }

}


