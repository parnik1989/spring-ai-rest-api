package com.eventsphere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eventsphere.entity.Venue;
import com.eventsphere.repositories.VenueRepository;

@Service
public class VenueService {

    private final VenueRepository repository;

    public VenueService(VenueRepository repository) {
        this.repository = repository;
    }

    public Venue create(Venue venue) {
        return repository.save(venue);
    }

    public List<Venue> getAll() {
        return repository.findAll();
    }

    public Venue getById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Venue update(Long id, Venue venue) {
        Venue existingVenue = repository.findById(id)
                .orElseThrow();
        
        if (venue.getName() != null) {
            existingVenue.setName(venue.getName());
        }
        if (venue.getCapacity() != null) {
            existingVenue.setCapacity(venue.getCapacity());
        }
        if (venue.getLocation() != null) {
            existingVenue.setLocation(venue.getLocation());
        }
        if (venue.getBasePrice() != null) {
            existingVenue.setBasePrice(venue.getBasePrice());
        }
        
        return repository.save(existingVenue);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
