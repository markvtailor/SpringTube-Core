package com.spring.tests.springtube.Controllers;

import com.spring.tests.springtube.Beans.request.CommentRequest;
import com.spring.tests.springtube.Beans.request.LikeRequest;
import com.spring.tests.springtube.Entities.CommentEntity;
import com.spring.tests.springtube.Entities.VideoEntity;
import com.spring.tests.springtube.Services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/stats")
@CrossOrigin //Опасно! Исправить
public class StatisticsController {

    @Autowired
    ViewService viewService;

    @PostMapping("video/comment")
    public CommentEntity postComment(@RequestBody CommentRequest request){
        return viewService.commentVideo(request.getAuthor(), request.getBody(), request.getVideoId());
    }

    @GetMapping("video/comments/{UUID}")
    public Iterable<CommentEntity> getAllComments(@PathVariable String UUID){
        return viewService.getComments(UUID);
    }

    @PutMapping("video/countview/{UUID}")
    public void countView(@PathVariable String UUID){
        viewService.countView(UUID);
    }
    @GetMapping("video/views/{UUID}")
    public int getViews(@PathVariable String UUID){
        return viewService.getViews(UUID);
    }
    @PutMapping("video/like")
    public void applyLikes(@RequestBody LikeRequest request){
        if(request.getValue().equals("1")){
            viewService.likeVideo(request.getVideoId(),request.getUser());
        }else if(request.getValue().equals("-1")){
            viewService.dislikeVideo(request.getVideoId(),request.getUser());
        }
    }

    @GetMapping("video/likes/{UUID}")
    public int countLikes(@PathVariable String UUID){
        return viewService.countLikes(UUID);
    }

    @GetMapping("/liked/{user}")
    public ArrayList<VideoEntity> getLikedVideos(@PathVariable String user){
        return viewService.getLikedVideos(user);
    }
}
