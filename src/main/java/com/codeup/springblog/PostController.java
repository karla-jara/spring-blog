package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostsRepository postsDao;
    private UsersRepository usersDao;
    private User userPosts;

    public PostController(PostsRepository postsRepository, UsersRepository usersRepository){
        postsDao = postsRepository;
        usersDao = usersRepository;
    }

    //posts index page
    @GetMapping("/posts")
    public String index(Model model){
        List<Post> postList = postsDao.findAll();
        model.addAttribute("noPostsFound", postList.size() == 0);
        model.addAttribute("ads", postList);
        model.addAttribute("posts", postsDao.findByTitle("wonder"));
        model.addAttribute("searchPostTitle", postsDao.findByTitleLike("%cycling%"));
        model.addAttribute("searchPostBody", postsDao.findPostsByBodyContaining("%SALR%"));
        model.addAttribute("deletePost",postsDao.deletePostByTitle("wonder"));

        return "posts/index";
    }

    //view an individual post
    @GetMapping("/posts/{id}")
    public String id(@PathVariable Long id, Model model){
        Post post= postsDao.getById(id);
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
        postsDao.save(post1);
        return "redirect:/posts/" + id;
    }

    @GetMapping("post/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("postEditedPost",postsDao.getById( id));
        return "posts/edit";
    }

}
