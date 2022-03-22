package com.codepresso.team2app.controller.dto;

import com.codepresso.team2app.vo.HashTag;
import lombok.Getter;

@Getter
public class HashTagResponseDto {
    Long id;
    String tag_content;
    Long post_id;
    Long comment_id;

    public HashTagResponseDto(HashTag hashTag) {
        this.id = hashTag.getId();
        this.tag_content = hashTag.getTag_content();
        this.post_id =  hashTag.getPost_id();
        this.comment_id = hashTag.getComment_id();
    }
}
