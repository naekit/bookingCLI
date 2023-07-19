package services;

import dao.MentorDao;
import models.Mentor;

import java.util.List;

public class MentorService {
    private final MentorDao mentorDao;

    public MentorService() {
        this.mentorDao = new MentorDao();
    }

    public void addMentor(Mentor mentor){
        mentorDao.addMentor(mentor);
    }

    public List<Mentor> getAllMentors(){
        return mentorDao.getAllMentors();
    }

    public Mentor getMentorByName(String mentorName) {
        return mentorDao.getMentorByName(mentorName);
    }
}
