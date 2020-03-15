package pl.dm.libraryprojectdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dm.libraryprojectdm.model.Author;
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
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authorList";
    }

    @GetMapping("/add/form")
    public String addAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorAdd";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/author/list";
    }

    @PostMapping("/delete")
    public String deleteAuthor(@RequestParam Long authorId) {
        authorService.delete(authorId);
        return "redirect:/author/list";
    }


    @GetMapping("/edit/form")
    public String editAuthorForm(@RequestParam Long authorEditId, Model model) {
        Author authorToEdit = authorService.findAuthorById(authorEditId.intValue() - 1);
        model.addAttribute("author", authorToEdit);
        return "authorEdit";
    }

    @PostMapping("/edit")
    public String editAuthor(@ModelAttribute Author author) {
        authorService.delete(author.getId());
        authorService.save(author);
        //authorService.update(author);
        return "redirect:/author/list";
    }


}
