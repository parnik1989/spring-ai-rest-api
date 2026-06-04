package com.eventsphere.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventsphere.entity.Booking;
import com.eventsphere.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/createBooking")
    public Booking create(@RequestBody Booking booking) {
        return service.create(booking);
    }

    @GetMapping("/getAll")
    public List<Booking> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Booking getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/getByCustomerId/{customerId}")
    public List<Booking> getByCustomerId(@PathVariable Long customerId) {
        return service.getByCustomerId(customerId);
    }

    @GetMapping("/getByVenueId/{venueId}")
    public List<Booking> getByVenueId(@PathVariable Long venueId) {
        return service.getByVenueId(venueId);
    }

    @GetMapping("/getByStatus")
    public List<Booking> getByStatus(@RequestParam String status) {
        return service.getByStatus(status);
    }

    @PutMapping("/updateBooking/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking booking) {
        return service.update(id, booking);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
