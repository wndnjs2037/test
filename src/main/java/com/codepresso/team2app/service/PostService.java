package com.codepresso.team2app.service;

import com.codepresso.team2app.repository.FriendTagRepository;
import com.codepresso.team2app.repository.HashTagRepositroy;
import com.codepresso.team2app.repository.LikeRepository;
import com.codepresso.team2app.repository.PostRepository;
import com.codepresso.team2app.vo.FriendTag;
import com.codepresso.team2app.vo.HashTag;
import com.codepresso.team2app.vo.Like;
import com.codepresso.team2app.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;
    private HashTagRepositroy hashTagRepositroy;
    private FriendTagRepository friendTagRepository;
    private LikeRepository likeRepository;

    public PostService(PostRepository postRepository, HashTagRepositroy hashTagRepositroy, FriendTagRepository friendTagRepository, LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.hashTagRepositroy = hashTagRepositroy;
        this.friendTagRepository = friendTagRepository;
        this.likeRepository = likeRepository;
    }

    public boolean savePost(Post post, HashTag hashTag){
        Integer result = postRepository.save(post, hashTag);
        hashTagRepositroy.saveHashTag(hashTag);
        return result == 1;
    }

    public boolean saveHashTag(HashTag hashTag){
        Integer result = hashTagRepositroy.saveHashTag(hashTag);
        return result == 1;
    }

    public boolean saveFriendTag(FriendTag friendTag){
        Integer result = friendTagRepository.saveFriendTag(friendTag);
        return result == 1;
    }
    public boolean saveOnlyPost(Post post){
        Integer result = postRepository.savePost(post);
        return result == 1;
    }

    public List<Post> getAllPost() {
        return postRepository.findAllPost();
    }

    public boolean countSave(Like like) { //insert 쿼리
        Integer result = likeRepository.countSave(like);
        return result == 1; //True 반환
    }

    public boolean updateLike(Post post){
        Integer result = postRepository.updateLike(post);
        return result == 1;
    }



}
