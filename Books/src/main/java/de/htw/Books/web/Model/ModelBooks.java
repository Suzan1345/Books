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
        private String genre;
        private Long isbn;
        private String desch;
        private int rating;

        public ModelBooks() {}

        public ModelBooks(Long id, String title, String author, String genre,
                          Long isbn, String desch, int rating) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.isbn = isbn;
            this.desch = desch;
            this.rating = rating;
        }

        // Getter und Setter
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

    public String getGenre(){ return genre;}
    public void setGenre(String genre){this.genre = genre;}

    public Long getIsbn(){return isbn;}
    public void setIsbn(Long isbn){this.isbn = isbn;}

    public String getDesc(){return desch;}
    public void setDesc(String desch) {
        this.desch = desch;}

    public int getRating() {
        return rating;}

    public void setRating(int rating) {
        this.rating = rating;}
}

