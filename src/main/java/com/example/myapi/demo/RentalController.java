package com.example.myapi.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@RestController
public class RentalController {

    @PostMapping("registerCar")
    public String registerCar(@RequestBody Car car) throws SQLException {
        DBManager manager = new DBManager();
        manager.addCar(car);
        return "Pridėta";
    }

    @PostMapping("registerClient")
    public String registerClient(@RequestBody Client client) throws SQLException {
        DBManager manager = new DBManager();
        manager.addClient(client);
        return "Pridėta";
    }

    @GetMapping("getcarlist")
    public List<Car> getCarList() throws SQLException {
        DBManager manager = new DBManager();
        return manager.getAllCarsList();
    }

    @GetMapping("getcarbyid")
    public Car carById(int id) throws SQLException {
        DBManager manager = new DBManager();
        return manager.getCarById(id);
    }



}
