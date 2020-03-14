package pl.dm.libraryprojectdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dm.libraryprojectdm.service.IAuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private IAuthorService authorService;

    @Autowired
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String showAllAuthors(Model model){
        model.addAttribute("authors",authorService.findAll());
        return "authorList";
    }

}
