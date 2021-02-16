package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.PostRepository;
import com.example.Aplication.model.table.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {
    @Autowired
    private PostRepository  postRepository;

    @PostMapping("/post")
    public Object  post(Post post) {
        APIResponse response = new APIResponse();
            postRepository.save(post);
            System.out.print(post);
            response.setMessage("Post success");
            response.setData(post);
            response.setStatus(1);
        return response;
    }

    @GetMapping("/postList")
    public Object postList(Post post){
        APIResponse response = new APIResponse();
        List<Post> getPost = postRepository.findAll();
        response.setMessage("List Post");
        response.setData(getPost);
        return response;
    }
}
