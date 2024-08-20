package com.mano;

import com.mano.domain.Answer;
import com.mano.domain.Comment;
import com.mano.domain.Like;
import com.mano.domain.Question;
import com.mano.domain.StackOverFlow;
import com.mano.domain.Tag;
import com.mano.domain.User;

///Users can post questions, answer questions, and comment on questions and answers.
// Users can vote on questions and answers.
// Questions should have tags associated with them.
// Users can search for questions based on keywords, tags, or user profiles.
// The system should assign reputation score to users based on their activity and the quality of their contributions.
// The system should handle concurrent access and ensure data consistency.

public class Main {
    public static void main(String[] args) {
        StackOverFlow instance = new StackOverFlow();
        User abhi = new User(1,"abhishek" , "abhishek@gmail.com");
        User suresh = new User(2, "suresh" , "suresh@gmail.com");
        instance.addUser(suresh);
        instance.addUser(abhi);
        Question javaq = new Question("How to Run Java" , "I would like to know how to run a java code" , abhi);
        instance.addQuestion(javaq);
        Answer javanswer = new Answer("Easy Fix","Run it using JAVAC followed by program name", suresh);
        javaq.addAnswer(javanswer);
        javanswer.addLike(new Like(abhi));
        javaq.addLike(new Like(abhi));
        Comment javaComment = new Comment("Dont ask these silly questions", suresh);
        javaq.addComment(javaComment);
       
        javaq.addLike(new Like(suresh));
        javaq.addTag(new Tag("Programming"));
        javaq.addTag(new Tag("Java"));
        javaq.display();

    }
}