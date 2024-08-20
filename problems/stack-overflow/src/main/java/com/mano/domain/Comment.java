package com.mano.domain;

import lombok.Data;

@Data
public class Comment {
    private String description;
    private User author;
}
