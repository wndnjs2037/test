package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.HashTag;
import com.codepresso.team2app.vo.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagRequestDto {
    Long id;
    String tag_content;
    Long post_id;
    Long comment_id;

    public HashTag getPostHashTag(){
        return new HashTag(this.id, this.tag_content, this.post_id, null);
    }

    public HashTag getCommentTag(){
        return new HashTag(this.id, this.tag_content, null, this.comment_id);
    }
}
