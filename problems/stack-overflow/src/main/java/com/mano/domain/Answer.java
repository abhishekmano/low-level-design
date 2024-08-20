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
    @Override
    public void addLike(Like like) {
        likes.addLast(like);
    }
    @Override
    public void addComment(Comment comment) {
       comments.addLast(comment);
    }
}
