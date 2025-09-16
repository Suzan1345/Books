package de.htw.Books.web.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "books")
public class ModelBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String author;

        public ModelBooks() {}

        public ModelBooks(Long id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        // Getter und Setter
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
    }

