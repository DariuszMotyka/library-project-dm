package pl.dm.libraryprojectdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dm.libraryprojectdm.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
