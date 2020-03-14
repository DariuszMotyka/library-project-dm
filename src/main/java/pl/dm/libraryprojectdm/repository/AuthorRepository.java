package pl.dm.libraryprojectdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dm.libraryprojectdm.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
