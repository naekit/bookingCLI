package models;

import java.util.Objects;

public class Lesson {
    private String name;
    private String subject;
    private Mentor mentor;

    public Lesson(String name, String subject, Mentor mentor) {
        this.name = name;
        this.subject = subject;
        this.mentor = mentor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(name, lesson.name) && Objects.equals(subject, lesson.subject) && Objects.equals(mentor, lesson.mentor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject, mentor);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "title='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", mentor=" + mentor +
                '}';
    }
}
