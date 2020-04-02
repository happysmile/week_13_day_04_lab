package com.example.codeClan.courses.repositories;

import com.example.codeClan.courses.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Get all bookings for a given date
    List<Booking> findBookingByDate(String date);
}
