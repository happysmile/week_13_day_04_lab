package com.example.codeClan.courses.repositories;

import com.example.codeClan.courses.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Get all courses with a given rating
    List<Course> findCourseByRating(int rating);

    //  Get all courses for a given customer
    List<Course> findCourseByBookingsCustomerId(Long CustomerId);


}
