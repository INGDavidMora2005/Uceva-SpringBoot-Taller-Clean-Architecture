package uceva.cleanarchitecture.infrastructure.repository;

import uceva.cleanarchitecture.domain.entity.Book;
import uceva.cleanarchitecture.domain.repository.BookRepository;
import uceva.cleanarchitecture.infrastructure.datasource.BookDatasource;

import java.util.List;

/**
 * Implementación concreta del repositorio de libros.
 *
 * Pertenece a la capa de Infrastructure y actúa como adaptador entre
 * el contrato del dominio {@link BookRepository} y la fuente de datos
 * {@link BookDatasource}. No contiene lógica de negocio.
 */
public class BookRepositoryImpl extends BookRepository {

    private final BookDatasource bookDatasource;

    /**
     * Crea una nueva instancia del repositorio de libros.
     *
     * @param bookDatasource fuente de datos utilizada para obtener los libros
     */
    public BookRepositoryImpl(BookDatasource bookDatasource){
        this.bookDatasource = bookDatasource;
    }

    /**
     * Obtiene el listado de libros delegando en el datasource.
     *
     * @param countBooks cantidad de libros a obtener
     * @return lista de {@link Book}
     */
    @Override
    public List<Book> getAll(int countBooks) {
        return bookDatasource.getAll(countBooks);
    }
}
