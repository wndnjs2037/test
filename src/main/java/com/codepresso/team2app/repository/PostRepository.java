package com.codepresso.team2app.repository;

import com.codepresso.team2app.vo.HashTag;
import com.codepresso.team2app.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostRepository {
    Integer save(@Param("post") Post post, HashTag hashTag);
    Integer savePost(@Param("post") Post post);
    List<Post> findAllPost();
    Integer updateLike(@Param("post") Post post);
}
