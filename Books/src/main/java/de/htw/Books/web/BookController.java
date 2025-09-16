package de.htw.Books.web;

import de.htw.Books.web.Model.ModelBooks;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin // optional: ggf. Origin einschränken
public class BookController {

    private record CreateBookRequest(@NotBlank String title, @NotBlank String author, @NotBlank String genre,
                                     @NotNull @Positive Long isbn, @NotBlank String desc, @NotNull int rating) {}

    private final BookRepository repo;
    public BookController(BookRepository repo) { this.repo = repo; }

    @PostMapping
    public ResponseEntity<ModelBooks> create(@Valid @RequestBody CreateBookRequest req) {
        ModelBooks saved = repo.save(new ModelBooks(null, req.title(), req.author(), req.genre(),
                req.isbn(), req.desc(), req.rating() ));
        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public List<ModelBooks> all() {
        return repo.findAll();
    }
}
