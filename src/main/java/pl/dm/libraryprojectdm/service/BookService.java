package pl.dm.libraryprojectdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dm.libraryprojectdm.model.Author;
import pl.dm.libraryprojectdm.model.Book;
import pl.dm.libraryprojectdm.model.BookType;
import pl.dm.libraryprojectdm.repository.AuthorRepository;
import pl.dm.libraryprojectdm.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        Optional<Author> author = authorRepository.findById(book.getAuthorId());
        author.ifPresent(a -> book.setAuthor(a));
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Book book) {
        if (book != null && id != null) {
            bookRepository.findById(id).get().setTitle(book.getTitle());
            bookRepository.findById(id).get().setIsbn(book.getIsbn());
            bookRepository.findById(id).get().setCategory(book.getCategory());
            bookRepository.findById(id).get().setReleaseDate(book.getReleaseDate());
            bookRepository.findById(id).get().setAuthorId(book.getAuthorId());
            bookRepository.findById(id).get().setQuantity(book.getQuantity());
            bookRepository.flush();
        }
    }

    @Override
    public List<String> findAllCategories() {
        return Arrays.stream(BookType.values()).map(Enum::name).collect(Collectors.toList());
    }
}
