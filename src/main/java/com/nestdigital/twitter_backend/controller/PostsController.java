package com.nestdigital.twitter_backend.controller;


import com.nestdigital.twitter_backend.dao.PostsDao;
import com.nestdigital.twitter_backend.model.PostsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class PostsController {

    @Autowired
    private PostsDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addpost",consumes = "application/json" ,produces = "application/json")
    public String addPost(@RequestBody PostsModel posts)
    {
        DateTimeFormatter dt =DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String CurrentDate=String.valueOf(dt.format(now));
        posts.setPostdate(dt.format(now));
        System.out.println(posts.toString());
        dao.save(posts);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewposts")
    public List<Map<String,String>>viewAllPosts()
    {
        return  (List<Map<String,String>>)dao.ViewAllPosts();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/individual", consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> IndividualPost(@RequestBody PostsModel posts)
    {
        return  (List<Map<String,String>>)dao.Individual(posts.getUserid());
    }




}
