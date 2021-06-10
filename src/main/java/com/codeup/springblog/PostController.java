package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    //posts index page
    @GetMapping("/post")
    @ResponseBody
    public String post(){
        return "This is the index page.";
    }

    //view an individual post
    @GetMapping("/post{id}")
    @ResponseBody
    public String id(@PathVariable long id){
        return "The id number is: " + id;
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
