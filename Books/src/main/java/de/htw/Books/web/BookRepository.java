package de.htw.Books.web;

import de.htw.Books.web.Model.ModelBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<ModelBooks, Long> {
    // Liefert das erste Buch (nach ID aufsteigend)
    Optional<ModelBooks> findFirstByOrderByIdAsc();
}
