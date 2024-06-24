package com.example.myapi.demo.controller;

import com.example.myapi.demo.model.Car;
import com.example.myapi.demo.model.Client;
import com.example.myapi.demo.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CarController {

    CarService carService = new CarService();
    public CarController() throws SQLException {
    }

    @PostMapping("registerCar")
    public Car registerCar(@RequestBody Car car) throws SQLException {
        carService.addCar(car);
        return car;
    }
    @GetMapping("getcarlist")
    public List<Car> getCarList() throws SQLException {
        return carService.getAllCarsList();
    }

    @GetMapping("getcarbyid")
    public Car carById(int id) throws SQLException {
        return carService.getCarById(id);
    }



}

