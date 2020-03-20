package pl.dm.libraryprojectdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dm.libraryprojectdm.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {

    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/list")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }

}
