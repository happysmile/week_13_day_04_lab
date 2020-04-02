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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Customer>> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Customer>> updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setLocation(updatedCustomer.getLocation());
            customer.setAge(updatedCustomer.getAge());
            customer.setBookings(updatedCustomer.getBookings());
            return customerRepository.save(customer);
        }), HttpStatus.OK);
    }





}
