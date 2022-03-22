package com.codepresso.team2app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTag {
    Long id;
    String tag_content;
    Long post_id;
    Long comment_id;

    public HashTag(Long id, String tag_content, Long post_id, Long comment_id) {
        this.id = id;
        this.tag_content = tag_content;
        this.post_id = post_id;
        this.comment_id = comment_id;
    }
}
