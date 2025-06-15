package de.htw.Books.web;

import de.htw.Books.web.Model.ModelBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<ModelBooks> getBooks() {
        return List.of(
                new ModelBooks(1L, "Der kleine Prinz", "Antoine de Saint-Exupéry"),
                new ModelBooks(2L, "Harry Potter", "J.K. Rowling")
        );
    }

    @PostMapping
    public ModelBooks createBook(@RequestBody ModelBooks book) {
        // Dummy-Antwort, Datenbankzugriff entfernt
        return new ModelBooks(999L, book.getTitle(), book.getAuthor());
    }

}
