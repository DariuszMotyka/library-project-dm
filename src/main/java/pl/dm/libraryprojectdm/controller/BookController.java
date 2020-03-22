package pl.dm.libraryprojectdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dm.libraryprojectdm.model.Author;
import pl.dm.libraryprojectdm.model.Book;
import pl.dm.libraryprojectdm.service.IAuthorService;
import pl.dm.libraryprojectdm.service.IBookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private IBookService bookService;
    private IAuthorService authorService;

    @Autowired
    public BookController(IBookService bookService, IAuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }

    @GetMapping("/add/form")
    public String addBookView(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("categories", bookService.findAllCategories());
        model.addAttribute("book", new Book());
        return "bookAdd";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/book/list";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam(required = false) Long bookId) {
        if (bookId != null) {
            try {
                bookService.delete(bookId);
                return "redirect:/book/list";
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        System.out.println("Error");
        return "redirect:/book/list";
    }

    @GetMapping("/edit/form")
    public String editBookForm(@RequestParam Long bookEditId, Model model) {
        Book bookToEdit = bookService.findBookById(bookEditId);
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("categories", bookService.findAllCategories());
        model.addAttribute("bookToEdit", bookToEdit);
        return "bookEdit";
    }

    //TODO fix editBook method > save data to db
    @PostMapping("/edit")
    public String editBook(@ModelAttribute Book book, @RequestParam Long bookIdToEdit) {
        bookService.update(bookIdToEdit, book);
        return "redirect:/book/list";
    }
}
