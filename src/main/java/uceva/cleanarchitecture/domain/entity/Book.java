package uceva.cleanarchitecture.domain.entity;

/**
 * Entidad que representa un libro del sistema.
 *
 * @remarks
 * El género debe ser uno de los siguientes valores:
 * - "Novela"
 * - "Ciencia"
 * - "Historia"
 * - "Tecnologia"
 */
public class Book {
    public Integer id;
    public String title;
    public String author;
    public Integer year;
    public String genre;

    public Book(Integer id, String title, String author, Integer year, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }
}
