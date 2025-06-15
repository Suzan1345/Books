package de.htw.Books.web;

import de.htw.Books.web.Model.ModelBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<ModelBooks, Long> {
}
