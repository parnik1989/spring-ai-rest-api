package com.eventsphere.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventsphere.entity.Venue;
import com.eventsphere.service.VenueService;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    @PostMapping("/createVenue")
    public Venue create(@RequestBody Venue venue) {
        return service.create(venue);
    }

    @GetMapping("/getAll")
    public List<Venue> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Venue getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/updateVenue/{id}")
    public Venue update(@PathVariable Long id, @RequestBody Venue venue) {
        return service.update(id, venue);
    }

    @DeleteMapping("/deleteVenue/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
