package models;

import java.util.Objects;

public class Lesson {
    private String title;
    private String subject;
    private Mentor mentor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(title, lesson.title) && Objects.equals(subject, lesson.subject) && Objects.equals(mentor, lesson.mentor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, subject, mentor);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", mentor=" + mentor +
                '}';
    }
}
