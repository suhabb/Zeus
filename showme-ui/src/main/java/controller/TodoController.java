package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @GetMapping("/angular/todo")
    public String getTodoList(){
        return "html/sports_todo";
    }
}
