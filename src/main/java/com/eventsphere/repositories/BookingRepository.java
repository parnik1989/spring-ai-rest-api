package com.eventsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventsphere.entity.Booking;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long customerId);
    List<Booking> findByVenueId(Long venueId);
    List<Booking> findByStatus(String status);
}
