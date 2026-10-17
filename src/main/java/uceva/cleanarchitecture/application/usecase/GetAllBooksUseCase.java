package uceva.cleanarchitecture.application.usecase;

import uceva.cleanarchitecture.domain.entity.Book;
import uceva.cleanarchitecture.domain.repository.BookRepository;

import java.util.List;

/**
 * Caso de uso para obtener un listado de libros.
 *
 * Pertenece a la capa de Application y depende únicamente del
 * contrato {@link BookRepository} definido en el dominio.
 * No usa anotaciones de Spring: el bean se registra en AppConfig.
 */
public class GetAllBooksUseCase {
    private final BookRepository bookRepository;

    /**
     * Crea una nueva instancia del caso de uso.
     *
     * @param bookRepository repositorio de libros utilizado para acceder a los datos
     */
    public GetAllBooksUseCase(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    /**
     * Ejecuta el caso de uso delegando la obtención de libros al repositorio.
     *
     * @param countBooks cantidad de libros a obtener
     * @return lista de {@link Book}
     */
    public List<Book> execute(int countBooks){
        return bookRepository.getAll(countBooks);
    }
}
