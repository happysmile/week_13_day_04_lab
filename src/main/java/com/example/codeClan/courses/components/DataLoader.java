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

        Customer jessica = new Customer("Jessica", "Coventry", 22);
        customerRepository.save(jessica);

        Customer john = new Customer("John", "Coventry", 18);
        customerRepository.save(john);

        Customer niall = new Customer("Niall", "Glasgow", 27);
        customerRepository.save(niall);

        Customer steve = new Customer("Steve", "Edinburgh", 30);
        customerRepository.save(steve);

        Customer linda = new Customer("Linda", "London", 40);
        customerRepository.save(linda);

        Course course1 = new Course("Software Development", "Glasgow", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Knitting", "London", 4);
        courseRepository.save(course2);

        Course course3 = new Course("Agile", "Edinburgh", 3);
        courseRepository.save(course3);

        Course course4 = new Course("Watercolours", "London", 5);
        courseRepository.save(course4);

        Course course5 = new Course("Guitar", "Glasgow", 1);
        courseRepository.save(course5);

        Booking booking1 = new Booking("2020-01-06", course1, harley);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("2020-01-10", course2, linda);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("2020-02-16", course3, niall);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("2020-01-15", course4, steve);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("2020-01-06", course5, steve );
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("2020-01-06", course1, linda );
        bookingRepository.save(booking6);

        Booking booking7 = new Booking("2020-01-06", course1, jessica );
        bookingRepository.save(booking7);

        Booking booking8 = new Booking("2020-01-06", course1, john );
        bookingRepository.save(booking8);

    }

}
