package com.example.codeClan.courses.controllers;

import com.example.codeClan.courses.models.Course;
import com.example.codeClan.courses.models.Customer;
import com.example.codeClan.courses.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(required = false, name="courseId") Long courseId,
            @RequestParam(required = false, name="location") String location,
            @RequestParam(required = false, name="minimumAge") Integer minimumAge
    ){
        if(courseId != null && location != null && minimumAge != null){
            return new ResponseEntity<>( customerRepository.findCustomerByBookingsCourseIdAndLocationAndAgeGreaterThanEqual(courseId, location, minimumAge),HttpStatus.OK );
        }
        if(courseId != null && location != null){
            return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseIdAndLocation(courseId, location), HttpStatus.OK);
        }
        if(courseId != null){
            return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseId(courseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }


}
