package pl.dm.libraryprojectdm.service;

import pl.dm.libraryprojectdm.model.Book;
import pl.dm.libraryprojectdm.repository.BookRepository;

import java.util.List;

public class BookService implements IBookService {

    private BookRepository bookRepository;


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
}
