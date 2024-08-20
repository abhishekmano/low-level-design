package com.mano.domain;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
public class Answer implements Commendable , Likable{
    private List<Like> likes;
    private List<Comment> comments ;
    private String title ;
    private String description;
    private User author;
    private LocalDateTime time ;
    public Answer(){
        likes = new LinkedList<>();
        comments = new LinkedList<>();
    }
    public Answer(String title , String description , User author){
        this();
        this.title = title;
        this.author = author;
        this.description = description;
    }
    @Override
    public void addLike(Like like) {
        likes.addLast(like);
    }
    @Override
    public void addComment(Comment comment) {
       comments.addLast(comment);
    }
    public void display(){
        System.out.println(title + "   " + author.getUserName() );
        System.out.println("\t" + description);
        for (Like like : likes) {
            like.display();
        }
        for (Comment comment : comments) {
            comment.display();
        }
    }
}
