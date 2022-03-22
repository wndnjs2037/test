package com.codepresso.team2app.controller;

import com.codepresso.team2app.controller.dto.HashTagRequestDto;
import com.codepresso.team2app.controller.dto.PostRequestDto;
import com.codepresso.team2app.controller.dto.PostResponseDto;
import com.codepresso.team2app.service.PostService;
import com.codepresso.team2app.vo.FriendTag;
import com.codepresso.team2app.vo.HashTag;
import com.codepresso.team2app.vo.Like;
import com.codepresso.team2app.vo.Post;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public String createPost(@RequestBody @Validated PostRequestDto postRequestDto) {
        Post post = postRequestDto.getPost();
        postService.saveOnlyPost(post);

        post.postInfo();
        HashTag hashTag;
        String content = post.getContent();

        Pattern HashTagPtn = Pattern.compile("\\#(\\S)*");
        Matcher HashTagMat = HashTagPtn.matcher(content);
        List<String> HashTags = new ArrayList<String>();
        long id = 1;
        while(HashTagMat.find()){
            HashTags.add(HashTagMat.group());
//            System.out.println(mat.group());
        }
//        System.out.println(cnt);
        for (int i = 0; i < HashTags.size(); i++) {
            hashTag = new HashTag(id, HashTags.get(i).substring(1), post.getId(), null);
            postService.saveHashTag(hashTag);
        }

        FriendTag friendTag;
        Pattern FriendTagPtn = Pattern.compile("\\@(\\S)*");
        Matcher FriendTagMat = FriendTagPtn.matcher(content);
        List<String> FriendTags = new ArrayList<String>();

        while(FriendTagMat.find()){
            FriendTags.add(FriendTagMat.group());
//            System.out.println(mat.group());
        }
//        System.out.println(cnt);
        for (int i = 0; i < FriendTags.size(); i++) {
            friendTag = new FriendTag(id, FriendTags.get(i).substring(1), id, id);
            postService.saveFriendTag(friendTag);
        }

        //post.getId()를 하면 null이 나오는 문제 해결 필요
        return "success";
    }

    @GetMapping("/post/all")
    public List<PostResponseDto> getAllPostList() {
        List<Post> postList = postService.getAllPost();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for(Post post : postList){
            postResponseDtos.add(new PostResponseDto(post));
//            System.out.println(post.getId());
        }

        return postResponseDtos;
    }

    @PutMapping("/post")
    public String updateLikeCount(@RequestBody Post post) {
        long author = 3;
        long id = 1;
        post = new Post(id, author, "ddd");
        postService.saveOnlyPost(post);
        postService.updateLike(post); //업데이트 쿼리 실행
        Like like;
        like = new Like(id, author, author);
        System.out.println(post.getAuthor());
        System.out.println(post.getId());
        postService.countSave(like);
        return "Success";
    }
}
