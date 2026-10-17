package uceva.cleanarchitecture.infrastructure.datasource;

import com.github.javafaker.Faker;
import uceva.cleanarchitecture.domain.entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Datasource encargado de generar libros simulados.
 *
 * Pertenece a la capa de Infrastructure y utiliza Faker para
 * generar información falsa de libros. No contiene lógica de negocio.
 */
public class BookDatasource {

    private Faker faker = new Faker();
    private final Random random = new Random();
    private final String[] genres = {"Novela", "Ciencia", "Historia", "Tecnologia"};
    private final String[] bookTitles = {
            "Cien años de soledad",
            "Clean Architecture",
            "Breve historia del tiempo",
            "El Quijote",
            "Sapiens",
            "Código limpio",
            "La peste",
            "Cosmos",
            "Los miserables",
            "Estructuras de datos y algoritmos",
            "Historia de Colombia",
            "El origen de las especies"
    };

    /**
     * Obtiene una lista de libros simulados.
     *
     * @param countBooks cantidad de libros a generar
     * @return lista de {@link Book} con ids de 1 a countBooks
     */
    public List<Book> getAll(int countBooks){
        List<Book> books = new ArrayList<Book>();
        for (int i = 1; i <= countBooks; i++) {
            books.add(generateBook(i));
        }
        return books;
    }

    /**
     * Genera un libro individual con datos simulados.
     *
     * @param id identificador único del libro
     * @return {@link Book} generado
     */
    private Book generateBook(Integer id){
        String title = bookTitles[random.nextInt(bookTitles.length)];
        String author = faker.name().fullName();
        int year = faker.number().numberBetween(1950, 2026); // límite superior exclusivo
        String genre = genres[random.nextInt(genres.length)];
        return new Book(id, title, author, year, genre);
    }
}
