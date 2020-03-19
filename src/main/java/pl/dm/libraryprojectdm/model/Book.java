package pl.dm.libraryprojectdm.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "isbn")
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private BookType category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Transient
    private Long authorId;
}
