package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("")
    @ResponseBody
    public String getLandingPage() {
        return "hello Spring MVC! :)";
    }
}
