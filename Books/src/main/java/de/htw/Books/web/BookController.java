package de.htw.Books.web;

import de.htw.Books.web.Model.ModelBooks;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin // optional: ggf. Origin einschränken
public class BookController {

    private record CreateBookRequest(@NotBlank String title, @NotBlank String author) {}

    private final BookRepository repo;
    public BookController(BookRepository repo) { this.repo = repo; }

    @PostMapping("/books")
    public ResponseEntity<ModelBooks> create(@Valid @RequestBody CreateBookRequest req) {
        ModelBooks saved = repo.save(new ModelBooks(null, req.title(), req.author()));
        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public List<ModelBooks> all() {
        return repo.findAll();
    }
}
