package com.example.Huibert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }



}

