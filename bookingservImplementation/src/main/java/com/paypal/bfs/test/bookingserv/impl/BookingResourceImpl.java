package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.api.model.Bookings;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.text.bookingserv.util.Idempotency;
import com.paypal.bfs.text.bookingserv.util.ModelMapper;
import com.paypal.bfs.text.bookingserv.util.ModelValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BookingResourceImpl implements BookingResource {
    
    private static final Logger LOG = LoggerFactory.getLogger(BookingResourceImpl.class);
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Override
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        
        // input validation
        if(!ModelValidation.validateBooking(booking)) {
            return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
        }
        
        // maintaining idempotency
        Booking response = checkIfBookingExists(booking);
        if(response != null) {
            return new ResponseEntity<Booking>(response, HttpStatus.OK);
        }
        
        // create new booking
        try {
            BookingEntity entity = ModelMapper.getBookingEntity(booking);
            bookingRepository.save(entity);
            response = ModelMapper.getBooking(entity);
            return new ResponseEntity<Booking>(response, HttpStatus.CREATED);
        } catch(Exception e) {
            LOG.error("error during creating booking resource", e);
            return new ResponseEntity<Booking>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Bookings> read() {
        
        try {
            List<BookingEntity> entitylist = (List<BookingEntity>) bookingRepository.findAll();
            if (entitylist == null || entitylist.isEmpty()) {
                return new ResponseEntity<Bookings>(HttpStatus.NOT_FOUND);
            }
            
            List<Booking> modelList = entitylist.stream().map(e -> ModelMapper.getBooking(e))
                    .collect(Collectors.toList());
            Bookings bookings = new Bookings();
            bookings.setBookingList(modelList);
            return new ResponseEntity<Bookings>(bookings, HttpStatus.OK);
        } catch(Exception e) {
            LOG.error("error during reading booking resource", e);
            return new ResponseEntity<Bookings>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    private Booking checkIfBookingExists(Booking booking) {
        
        String idempotencyId = Idempotency.getIdempotencyId(booking);
        List<BookingEntity> existingBookings = bookingRepository.findByIdempotencyId(idempotencyId);
        
        if(existingBookings != null && !existingBookings.isEmpty()) {
            
            Booking response = ModelMapper.getBooking(existingBookings.get(0));
            return response;
        }
        return null;
    }
}
