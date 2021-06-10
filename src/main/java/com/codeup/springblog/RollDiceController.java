package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice/{num}")
    public String getGuess(@PathVariable int num, Model model) {
        model.addAttribute("userGuess", num);
        model.addAttribute("hasGuessed", true);
        int n = 1 + (int)(Math.random() * (6 - 1));
        model.addAttribute("guess", n);
        return "roll-dice";
    }

    @GetMapping("/roll-dice")
    public String postGuess(Model model) {
        model.addAttribute("hasGuessed", false);
        return "roll-dice";
    }
}