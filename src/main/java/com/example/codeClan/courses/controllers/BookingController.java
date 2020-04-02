package com.example.codeClan.courses.controllers;

import com.example.codeClan.courses.models.Booking;
import com.example.codeClan.courses.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings(
            @RequestParam(required = false, name="date") String date
    ){
        if(date != null){
            return new ResponseEntity<>(bookingRepository.findBookingByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }




}
