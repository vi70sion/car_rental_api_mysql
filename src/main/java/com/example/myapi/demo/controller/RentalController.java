package com.example.myapi.demo.controller;

import com.example.myapi.demo.model.Rental;
import com.example.myapi.demo.service.RentalService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    RentalService rentalService = new RentalService();
    public RentalController() throws SQLException {    }

    @GetMapping
    public List<Rental> getAllRentalsList () throws SQLException {
        return rentalService.getAllRentalsList();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable int id) throws SQLException {
        return rentalService.getRentalById(id);
    }

    @PostMapping
    public Rental addRental(@RequestBody Rental rental) throws SQLException {
        rentalService.addRental(rental);
        return rental;
    }

    @PutMapping("/{id}")
    public boolean updateRental(@PathVariable int id, @RequestBody Rental rental) throws SQLException {
        return rentalService.updateRental(id, rental.getReturnDate());
    }

    @DeleteMapping("/{id}")
    public boolean deleteClient (@PathVariable int id) throws SQLException {
        return rentalService.deleteRental(id);
    }

}
