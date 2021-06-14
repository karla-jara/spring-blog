package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String index(Model model){
        model.addAttribute("posts", postDao.findByTitle("wonder"));
        model.addAttribute("searchPostTitle", postDao.findByTitleLike("%cycling%"));
        model.addAttribute("searchPostBody", postDao.findPostsByBodyContaining("%SALR%"));
        model.addAttribute("deletePost",postDao.deletePostByTitle("wonder"));

        return "posts/index";
    }

    //view an individual post
    @GetMapping("/posts/{id}")
    public String id(@PathVariable Long id, Model model){
        Post post= postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    //view all posts
    @GetMapping("/posts/all-posts")
    public String allPosts(){
       return "posts/index";
    }

    //view the form for creating a post
    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "Viewing create form";
    }

    //create a new post
    @PostMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "Viewing and able to create form";
    }

    // edit post
    @PostMapping("post/edit/{id}")
    public String editForm(@PathVariable Long id, @RequestParam String title, @RequestParam String body){
//        postDao.saveEditPost(id, title, body);
        Post post1 = new Post(id, title, body);
        postDao.save(post1);
        return "redirect:/posts/" + id;
    }

    @GetMapping("post/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("postEditedPost",postDao.getById( id));
        return "posts/edit";
    }

}
