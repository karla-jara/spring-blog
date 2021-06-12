package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    //posts index page
    @GetMapping("/posts")
    public String postIndex(Model model){
        model.addAttribute("posts", postDao.findByTitle("wonder"));
        model.addAttribute("searchPostTitle", postDao.findByTitleLike("%cycling%"));
        model.addAttribute("searchPostBody", postDao.findPostsByBodyContaining("%SALR%"));
        model.addAttribute("deletePost",postDao.deletePostByTitle("wonder"));
        model.addAttribute("editPost", postDao.saveEditPost(1L));
        return "posts/index";
    }

    //view an individual post
    @GetMapping("/post{id}")
    @ResponseBody
    public String id(@PathVariable long id, Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts/show";
    }

    //view all posts
    @GetMapping("/post{all-posts}")
    public String allPosts(){
       return "posts/index";
    }

    //view the form for creating a post
    @GetMapping("/post/create")
    @ResponseBody
    public String create(){
        return "Viewing create form";
    }

    //create a new post
    @PostMapping("/post/create")
    @ResponseBody
    public String createForm(){
        return "Viewing and able to create form";
    }

}
