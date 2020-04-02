package com.example.codeClan.courses.components;

import com.example.codeClan.courses.models.Booking;
import com.example.codeClan.courses.models.Course;
import com.example.codeClan.courses.models.Customer;
import com.example.codeClan.courses.repositories.BookingRepository;
import com.example.codeClan.courses.repositories.CourseRepository;
import com.example.codeClan.courses.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void run(ApplicationArguments args){

        Customer harley = new Customer("Harley", "Coventry", 22);
        customerRepository.save(harley);

        Course course1 = new Course("Software Development", "Glasgow", 5);
        courseRepository.save(course1);

        Booking booking1 = new Booking("2020-01-06", course1, harley);
        bookingRepository.save(booking1);

    }

}
