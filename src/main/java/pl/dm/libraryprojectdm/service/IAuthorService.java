package pl.dm.libraryprojectdm.service;


import pl.dm.libraryprojectdm.model.Author;

import java.util.List;

public interface IAuthorService {

    List<Author> findAll();

    void save(Author author);

    void delete(Long id);

}
