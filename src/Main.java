import models.Lesson;
import models.Mentor;
import models.Booking;
import services.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MentorService mentorService = new MentorService();
        LessonService lessonService = new LessonService(mentorService);
        BookingService bookingService = new BookingService(lessonService);

        while(true) {
            System.out.print("""
                1 - Book Lesson
                2 - View All Mentor Booked Lessons
                3 - View All Bookings
                4 - View Available Lessons
                5 - View Available Lessons By Subject
                6 - View All Mentors
                7 - Exit
                """);
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            switch (option) {
                case 1 -> {
                    List<Lesson> lessons = lessonService.getAllLessons();
                    if (lessons.isEmpty()) {
                        System.out.println("No available lessons.");
                        break;
                    }
                    for (int i = 0; i < lessons.size(); i++) {
                        System.out.println((i + 1) + " - " + lessons.get(i).getName());
                    }
                    System.out.println("Select a lesson by number:");
                    int lessonNumber = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline left-over
                    if (lessonNumber < 0 || lessonNumber >= lessons.size()) {
                        System.out.println("Invalid lesson number.");
                        break;
                    }
                    System.out.println("Enter student name:");
                    String studentName = scanner.nextLine();
                    Lesson selectedLesson = lessons.get(lessonNumber);
                    Booking newBooking = new Booking(selectedLesson, studentName);
                    bookingService.addBooking(newBooking);
                    System.out.println("Lesson booked.");
                }
                case 2 -> {
                    System.out.println("Enter mentor name:");
                    String mentorName = scanner.nextLine();
                    Mentor mentor = mentorService.getMentorByName(mentorName);
                    if (mentor == null) {
                        System.out.println("Mentor does not exist.");
                        break;
                    }
                    List<Booking> bookings = bookingService.getBookingsByMentor(mentorName);
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings found for this mentor.");
                        break;
                    }
                    for (Booking booking : bookings) {
                        System.out.println(booking.getStudentName() + " booked a lesson in " + booking.getLesson().getName());
                    }
                }
                case 3 -> System.out.println(bookingService.getAllBookings());
                case 4 -> System.out.println(lessonService.getAllLessons());
                case 5 -> {
                    List<String> subjects = lessonService.getAllSubjects();
                    if (subjects.isEmpty()) {
                        System.out.println("No subjects found.");
                        break;
                    }
                    System.out.println("Available subjects:");
                    for (int i = 0; i < subjects.size(); i++) {
                        System.out.println((i + 1) + " - " + subjects.get(i));
                    }
                    System.out.println("Select a subject by number:");
                    int subjectNumber = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline left-over
                    if (subjectNumber < 0 || subjectNumber >= subjects.size()) {
                        System.out.println("Invalid subject number.");
                        break;
                    }
                    String selectedSubject = subjects.get(subjectNumber);
                    List<Lesson> subjectLessons = lessonService.getLessonsBySubject(selectedSubject);
                    if (subjectLessons.isEmpty()) {
                        System.out.println("No lessons found for this subject.");
                        break;
                    }
                    System.out.println("Lessons in " + selectedSubject + ":");
                    for (Lesson lesson : subjectLessons) {
                        System.out.println(lesson.getName());
                    }
                }
                case 6 -> System.out.println(mentorService.getAllMentors());
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
