package pl.dm.libraryprojectdm.service;


import pl.dm.libraryprojectdm.model.Author;

import java.util.List;

public interface IAuthorService {

    List<Author> findAll();

    Author findAuthorById(int id);

    void save(Author author);

    void delete(Long id);

    void update(Long id, Author author);

}
