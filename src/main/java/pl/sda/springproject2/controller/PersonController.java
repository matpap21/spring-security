package pl.sda.springproject2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.springproject2.model.Person;
import pl.sda.springproject2.service.PersonService;

@Controller
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public String index(){
        return "person/index";
    }
    @GetMapping("/person/add")
    public String addPersonForm(){
        return "person/add-person-form";
    }
    @PostMapping("/person/add")
    public String addPerson(@ModelAttribute Person person, Model model){
        model.addAttribute("person", person);
        return "person/confirm-person";
    }
    @GetMapping("/person/list")
    public String todoList(Model model){
        model.addAttribute("personMap", personService.findAll());
        return "person-list";
    }
    @PostMapping("/person/available")
    public String setToDoCompleted(@RequestParam String pesel, @RequestParam Boolean available){
        personService.setifAvailable(pesel);
        // System.out.println(id);
        //  System.out.println(completed);
        //przekierowanie obsluge zadania do end -point
        return "redirect:/person/list";

    }
}
