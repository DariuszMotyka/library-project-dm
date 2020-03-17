package pl.dm.libraryprojectdm.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dm.libraryprojectdm.model.Author;
import pl.dm.libraryprojectdm.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {


    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Author author) {
        if (author != null && id != null) {
            authorRepository.findById(id).get().setFirstName(author.getFirstName());
            authorRepository.findById(id).get().setLastName(author.getLastName());
            authorRepository.flush();
        }
    }
}
