package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice/{num} {num2}")
    public String getGuess(@PathVariable int num, int num2, Model model) {
        model.addAttribute("userGuess", num);
        model.addAttribute("userGuess", num2);
        model.addAttribute("hasGuessed", true);
        int n = 1 + (int)(Math.random() * (6 - 1));
        int n2 = 1 + (int)(Math.random() * (6 - 1));
        model.addAttribute("guess", n);
        model.addAttribute("guess", n2);
        return "roll-dice";
    }

    @GetMapping("/roll-dice")
    public String postGuess(Model model) {
        model.addAttribute("hasGuessed", false);
        return "roll-dice";
    }
}