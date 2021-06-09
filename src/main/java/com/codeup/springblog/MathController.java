package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{number}/and/{number2}")
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number2) {
        return String.valueOf(number + number2);
    }
}
