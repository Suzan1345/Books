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
@CrossOrigin(
        origins = {
                "https://books-frontend-klg7.onrender.com",
                "http://localhost:5173" // für lokale Tests
        },
        allowedHeaders = "*",
        methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS }
)
public class BookController {

    private record CreateBookRequest(@NotBlank String title, @NotBlank String author, @NotBlank String genre,
                                     @NotNull @Positive Long isbn, @NotBlank String desch, @NotNull int rating) {}

    private final BookRepository repo;
    public BookController(BookRepository repo) { this.repo = repo; }

    @PostMapping
    public ResponseEntity<ModelBooks> create(@Valid @RequestBody CreateBookRequest req) {
        ModelBooks saved = repo.save(new ModelBooks(null, req.title(), req.author(), req.genre(),
                req.isbn(), req.desch(), req.rating() ));
        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public List<ModelBooks> all(@RequestParam(required = false) String genre) {
        if (genre == null || genre.isBlank()) {
            return repo.findAll();
        }
        return repo.findByGenreContainingIgnoreCase(genre.trim());
        // Für exakte Treffer stattdessen:
        // return repo.findByGenreIgnoreCase(genre.trim());
    }
    // GET /books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ModelBooks> byId(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /books/only
    @GetMapping("/only")
    public ResponseEntity<ModelBooks> only() {
        return repo.findFirstByOrderByIdAsc()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
