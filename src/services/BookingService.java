package services;

import dao.BookingDao;
import models.Booking;

import java.util.List;

public class BookingService {
    private final BookingDao bookingDao;

    public BookingService(){
        this.bookingDao = new BookingDao();
    }
    public BookingService(LessonService lessonService){
        this.bookingDao = new BookingDao(lessonService);
    }

    public void addBooking(Booking booking){
        bookingDao.addBooking(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingDao.getAllBookings();
    }

    public List<Booking> getBookingsByMentor(String mentorName){
        return bookingDao.getBookingsByMentor(mentorName);
    }
}
