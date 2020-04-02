package com.example.codeClan.courses.repositories;

import com.example.codeClan.courses.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Get all customers for a given course
    List<Customer> findCustomerByBookingsCourseId(Long CourseId);

    // Get all customers in a given town for a given course
    List<Customer> findCustomerByBookingsCourseIdAndLocationIgnoreCase(Long CourseId, String Location);

    // Get all customers over a certain age in a given town for a given course
    List<Customer> findCustomerByBookingsCourseIdAndLocationIgnoreCaseAndAgeGreaterThanEqual(Long CourseId, String Location, int age);
}
