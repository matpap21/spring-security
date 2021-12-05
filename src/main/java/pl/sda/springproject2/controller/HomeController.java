package pl.sda.springproject2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.springproject2.model.ToDo;
import pl.sda.springproject2.service.ToDoService;

@Controller
public class HomeController {
    private final ToDoService toDoService;

    public HomeController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/todo/add")
    public String toDoAddForm() {
        return "todo-add-form";
    }

    @PostMapping("/todo/add")
    public String toDoAdd(@ModelAttribute ToDo toDo, Model model) { // obiekt Model sluzy do widoku
        // TODO dodac nowe zadanie do kolekcji
        model.addAttribute("todo", toDoService.add(toDo));
        // System.out.println(toDo.getDeadLine().getYear());
        return "confirm-todo";
    }

    @GetMapping("/todo/list")
    public String toDoList(Model model) {
        model.addAttribute("todos", toDoService.findAll());
        return "todo-list";
    }
    @PostMapping("/todo/completed")
    public String setToDoCompleted(@RequestParam long id, @RequestParam Boolean completed){
        toDoService.setAsCompleted(id);
       // System.out.println(id);
      //  System.out.println(completed);
        //przekierowanie obsluge zadania do end -point
        return "redirect:/todo/list";

    }
}
