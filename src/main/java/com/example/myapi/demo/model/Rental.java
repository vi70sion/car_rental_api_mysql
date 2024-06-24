package com.example.myapi.demo.model;

import java.time.LocalDate;

public class Rental {
    private int rentalId;
    private int carId;
    private int clientId;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Rental() {
    }

    public Rental(int rentalId, int carId, int clientId, LocalDate rentalDate, LocalDate returnDate) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.clientId = clientId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public int getRentalId() { return rentalId; }
    public int getCarId() { return carId; }
    public int getClientId() { return clientId; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }


}
