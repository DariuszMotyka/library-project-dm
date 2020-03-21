package pl.dm.libraryprojectdm.service;

import pl.dm.libraryprojectdm.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Book findBookById(Long id);

    void save(Book book);

    void delete(Long id);

    void update(Long id, Book book);

    List<String> findAllCategories();

}
