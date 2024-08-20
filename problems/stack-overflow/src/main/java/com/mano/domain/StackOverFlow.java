package com.mano.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StackOverFlow {
    List<User> users;
    List<Question> questions;
    public StackOverFlow(){
        users = new LinkedList<>();
        questions = new LinkedList<>();
    }
    public void addUser(User user){
        users.add(user);
    }
    public void addQuestion(Question question){
        questions.add(question);
    }
    public List<Question> getQuestionsByUser(User user){
        List<Question> res = new ArrayList<>();
        for(var question : questions){
            if(question.getAuthor() == user){
                res.add(question);
            }
        }
        return res;
    }
    public List<Question> getQuestionsByTag(Tag tag){
        List<Question> res = new ArrayList<>();
        for(var question : questions){
            if(question.getTags().contains(tag)){
                res.add(question);
            }
        }
        return res;
    }
    public List<Question> getQuestionsByKeyWord(String word){
        List<Question> res = new ArrayList<>();
        for(var question : questions){
            if(question.getTitle().contains(word) || question.getDescription().contains(word)){
                res.add(question);
            }
        }
        return res;
    }


    
}
