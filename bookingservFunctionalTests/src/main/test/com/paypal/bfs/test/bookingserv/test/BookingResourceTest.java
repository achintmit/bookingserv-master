package com.paypal.bfs.test.bookingserv.test;


import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.BookingServApplication;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BookingServApplication.class)
@AutoConfigureMockMvc
public class BookingResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void createNewBooking() throws Exception {

        Booking booking = new Booking();
        booking.setFirstName("Achint");
        booking.setLastName("Mittal");
        booking.setBirthDate("1982/08/28");
        booking.setCheckinDate("2021/08/25");
        booking.setCheckoutDate("2021/08/27");
        
        Address address = new Address();
        address.setLine1("H.No. 123");
        address.setCity("Gurugram");
        address.setState("Haryana");
        address.setCountry("India");
        address.setZipCode("122018");

        booking.setAddress(address);

        String postBody = new ObjectMapper().writeValueAsString(booking);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/bfs/bookings").content(postBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void createDuplicateBooking() throws Exception {

        Booking booking = new Booking();
        booking.setFirstName("Achint");
        booking.setLastName("Mittal");
        booking.setBirthDate("1982/08/28");
        booking.setCheckinDate("2021/08/25");
        booking.setCheckoutDate("2021/08/27");
        
        Address address = new Address();
        address.setLine1("H.No. 123");
        address.setCity("Gurugram");
        address.setState("Haryana");
        address.setCountry("India");
        address.setZipCode("122018");

        booking.setAddress(address);

        String postBody = new ObjectMapper().writeValueAsString(booking);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/bfs/bookings").content(postBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }       
    
    @Test
    public void createNewBookingWithBadRequest() throws Exception {

        Booking booking = new Booking();
        booking.setFirstName("Achint");
        booking.setLastName("Mittal");
        booking.setBirthDate("1982/08/28");
        booking.setCheckinDate("2021/08/25");
        booking.setCheckoutDate("2021/08/27");

        String postBody = new ObjectMapper().writeValueAsString(booking);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/bfs/bookings").content(postBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }    
    
    @Test
    public void retrieveBookings() throws Exception {
        
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/bfs/bookings")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }           
}
