package no.oslomet.controller;

import no.oslomet.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    List<Author> authorList = new LinkedList<Author>();

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/listAuthor")
    public String listAuthor(Model model){
        model.addAttribute("authors",authorList);
        return "listAuthor";
    }

    @RequestMapping("/authorForm")
    public String formAuthor(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "authorForm";
    }

    @RequestMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author){
        author.setId(authorList.size()+1);
        authorList.add(author);
        return "redirect:/listAuthor";
    }



}
