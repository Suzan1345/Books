package de.htw.Books.web;

import de.htw.Books.web.Model.ModelBooks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class BookController {
    @GetMapping("/")
    public List<ModelBooks> getBooks() {
        return List.of(
                new ModelBooks(1L, "Der kleine Prinz", "Antoine de Saint-Exupéry"),
                new ModelBooks(2L, "Harry Potter", "J.K. Rowling")
        );
    }
}