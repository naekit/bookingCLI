package dao;

import models.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    private final List<Booking> bookings;

    public BookingDao() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public List<Booking> getAllBookings(){
        return bookings;
    }

    public List<Booking> getBookingsByMentor(String mentorName){
        List<Booking> mentorBookings = new ArrayList<>();
        for(Booking booking: bookings){
            if(booking.getLesson().getMentor().getName().equalsIgnoreCase(mentorName)){
                mentorBookings.add(booking);
            }
        }
        return mentorBookings;
    }
}
