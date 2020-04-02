package com.example.codeClan.courses.controllers;

import com.example.codeClan.courses.models.Booking;
import com.example.codeClan.courses.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }


}
