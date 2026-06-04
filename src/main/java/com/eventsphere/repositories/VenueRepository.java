package com.eventsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventsphere.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
