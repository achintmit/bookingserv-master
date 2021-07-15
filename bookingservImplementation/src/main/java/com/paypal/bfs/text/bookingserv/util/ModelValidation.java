package com.paypal.bfs.text.bookingserv.util;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

public class ModelValidation {

    public static boolean validateBooking(Booking booking) {
        
        if(booking.getFirstName() == null || booking.getFirstName().isEmpty() || booking.getFirstName().length() > 255) {
            return false;
        }
        if(booking.getLastName() == null || booking.getLastName().isEmpty() || booking.getLastName().length() > 255) {
            return false;
        }
        if(booking.getBirthDate() == null) {
            return false;
        }
        if(booking.getCheckinDate() == null || booking.getCheckoutDate() == null) {
            return false;
        }
        
        return validateAddress(booking.getAddress());
    }
    
    private static boolean validateAddress(Address address) {
        
        if(address == null 
                || address.getLine1() == null || address.getLine1().isEmpty()
                || address.getCity() == null || address.getCity().isEmpty()
                || address.getState() == null || address.getState().isEmpty()
                || address.getCountry() == null || address.getCountry().isEmpty()
                || address.getZipCode() == null || address.getZipCode().isEmpty()) {
            return false;
        }
        
        return true;
    }
}
