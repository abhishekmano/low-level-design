package com.mano.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Question implements Likable , Commendable {
    List<Like> likes;
    List<Comment> comments;
    List<Tag> tags ;
    private String title ;
    private String description;
    public Question(){
        likes = new ArrayList<>();
        comments = new ArrayList<>();
    }
    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    @Override
    public void addLike(Like like) {
        likes.add(like);
    }
    public void addTag(Tag tag){
        tags.add(tag);
    }

}
