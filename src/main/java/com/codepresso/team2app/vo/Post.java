package com.codepresso.team2app.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Post {
    Long id;
    Long author;
    String content;
    Date createdAt;
    Long count_liked;
    Long count_revogel;
    Long count_comment;
    Long revogel_post_id;

    public Post(Long id, Long author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public void postInfo(){
        System.out.println("id " + this.id);
        System.out.println(this.getId());
        System.out.println("author " + this.author);
        System.out.println(this.getAuthor());
    }
}
