package dao;

import models.Lesson;
import models.Mentor;
import services.MentorService;

import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private final List<Lesson> lessons;

    public LessonDao(){
        this.lessons = new ArrayList<>();
//        add initial lessons
        this.lessons.add(new Lesson("Critical Reasoning", "Logic", new Mentor("Nikita")));
        this.lessons.add(new Lesson("Programming Fundamentals", "Computer Science", new Mentor("Derek")));
        this.lessons.add(new Lesson("Business Sense", "Logic", new Mentor("Archie")));
    }

    public LessonDao(MentorService mentorService){
        this.lessons = new ArrayList<>();
        List<Mentor> mentors = mentorService.getAllMentors();
//        initial mentors from list
        this.lessons.add(new Lesson("Critical Reasoning", "Logic", mentors.get(0)));
        this.lessons.add(new Lesson("Programming Fundamentals", "Computer Science", mentors.get(1)));
        this.lessons.add(new Lesson("Business Sense", "Logic", mentors.get(2)));
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Lesson> getAllLessons() {
        return lessons;
    }

    public List<Lesson> getLessonsBySubject(String subject) {
        List<Lesson> subjectLessons = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getSubject().equalsIgnoreCase(subject)) {
                subjectLessons.add(lesson);
            }
        }
        return subjectLessons;
    }
}
