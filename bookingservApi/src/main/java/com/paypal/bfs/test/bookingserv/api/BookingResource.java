package com.paypal.bfs.test.bookingserv.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.api.model.Bookings;

public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @PostMapping("/v1/bfs/bookings")
    ResponseEntity<Booking> create(@RequestBody Booking booking);

    
    @GetMapping("/v1/bfs/bookings")
    ResponseEntity<Bookings> read();
}
