package com.example.codeClan.courses.controllers;

import com.example.codeClan.courses.models.Course;
import com.example.codeClan.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(
        @RequestParam(required=false, name="rating") Integer rating,
        @RequestParam(required=false, name="customerId") Long customerId
    ){
        if(rating != null){
            return new ResponseEntity<>(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        }
        if(customerId !=null){
            return new ResponseEntity<>(courseRepository.findCourseByBookingsCustomerId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }





}
