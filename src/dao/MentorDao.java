package dao;

import models.Mentor;

import java.util.ArrayList;
import java.util.List;

public class MentorDao {
    private final List<Mentor> mentors;

    public MentorDao(){
        this.mentors = new ArrayList<>();
//        initial mentors
        this.mentors.add(new Mentor("Nikita"));
        this.mentors.add(new Mentor("Derek"));
        this.mentors.add(new Mentor("Archie"));
    }

    public void addMentor(Mentor mentor){
        mentors.add(mentor);
    }

    public List<Mentor> getAllMentors(){
        return mentors;
    }

    public Mentor getMentorByName(String mentorName){
        for (Mentor mentor: mentors){
            if(mentor.getName().equalsIgnoreCase(mentorName)){
                return mentor;
            }
        }
        return null;
    }
}
