package com.eventsphere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eventsphere.entity.Booking;
import com.eventsphere.repositories.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking create(Booking booking) {
        return repository.save(booking);
    }

    public List<Booking> getAll() {
        return repository.findAll();
    }

    public Booking getById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public List<Booking> getByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public List<Booking> getByVenueId(Long venueId) {
        return repository.findByVenueId(venueId);
    }

    public List<Booking> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    public Booking update(Long id, Booking booking) {
        Booking existingBooking = repository.findById(id)
                .orElseThrow();
        
        if (booking.getEventDate() != null) {
            existingBooking.setEventDate(booking.getEventDate());
        }
        if (booking.getEventType() != null) {
            existingBooking.setEventType(booking.getEventType());
        }
        if (booking.getExpectedGuests() != null) {
            existingBooking.setExpectedGuests(booking.getExpectedGuests());
        }
        if (booking.getAdvancePaid() != null) {
            existingBooking.setAdvancePaid(booking.getAdvancePaid());
        }
        if (booking.getStatus() != null) {
            existingBooking.setStatus(booking.getStatus());
        }
        if (booking.getNotes() != null) {
            existingBooking.setNotes(booking.getNotes());
        }
        
        return repository.save(existingBooking);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
