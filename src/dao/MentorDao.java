package dao;

import models.Mentor;

import java.util.ArrayList;
import java.util.List;

public class MentorDao {
    private final List<Mentor> mentors;

    public MentorDao(){
        this.mentors = new ArrayList<>();
    }

    public void addMentor(Mentor mentor){
        mentors.add(mentor);
    }

    public List<Mentor> getAllMentors(){
        return mentors;
    }
}
