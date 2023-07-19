package models;

import java.util.Objects;

public class Booking {
    private Lesson lesson;
    private String studentName;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(lesson, booking.lesson) && Objects.equals(studentName, booking.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lesson, studentName);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "lesson=" + lesson +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
