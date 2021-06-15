package com.codeup.springblog;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {
    private final UsersRepository usersDao;
    private PostsRepository postsDao;
    private Post post;

    public UserController(UsersRepository usersRepository, PostsRepository postsRepository) {
        usersDao = usersRepository;
        postsDao = postsRepository;
    }

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> postList = postsDao.findAll();
        model.addAttribute("noPostsFound", postList.size() == 0);
        model.addAttribute("posts", postList);
        return "posts/show";
    }

}
