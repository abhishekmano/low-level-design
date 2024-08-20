package com.mano.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Question implements Likable , Commendable {
    List<Like> likes;
    List<Comment> comments;
    List<Tag> tags ;
    List<Answer> answers ;
    private String title ;
    private String description;
    private User author;
    private Question(){
        likes = new ArrayList<>();
        comments = new ArrayList<>();
        answers = new ArrayList<>();
        tags = new ArrayList<>();
    }
    public Question(String title , String desc , User author){
        this();
        this.title = title;
        this.description = desc;
        this.author = author;
        
        
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public void addAnswer(Answer answer){
        answers.add(answer);
    }
    @Override
    public void addLike(Like like) {
        likes.add(like);
    }
    public void addTag(Tag tag){
        tags.add(tag);
    }
    public void display(){
        System.out.println("Title : "+ title  + "  by : " + author.getUserName());
        System.out.println(description);
        for(Like like : likes){
            like.display();
        }
        System.out.println("Answers");
        for (Answer answer : answers) {
            answer.display();
        }
        for (Comment comment : comments) {
            comment.display();
        }
    }


}
