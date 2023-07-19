package services;

import dao.LessonDao;
import models.Lesson;

import java.util.List;

public class LessonService {
    private final LessonDao lessonDao;

    public LessonService() {
        this.lessonDao = new LessonDao();
    }

    public void addLesson(Lesson lesson){
        lessonDao.addLesson(lesson);
    }

    public List<Lesson> getAllLessons(){
        return lessonDao.getAllLessons();
    }

    public List<Lesson> getLessonsBySubject(String subject){
        return lessonDao.getLessonsBySubject(subject);
    }
}
