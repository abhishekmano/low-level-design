package com.mano.domain;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
public class Comment implements Likable {
    List<Like> likes ;
    private String description;
    private User author;
    public Comment(String desc , User author){
        description = desc;
        this.author = author;
        likes  = new LinkedList<>();
    }
    @Override
    public void addLike(Like like) {
        likes.add(like);
    }
    public void display(){
        System.err.println(author.getUserName() + " : " + description);
        for (Like like : likes) {
            like.display();
        }
    }
}
