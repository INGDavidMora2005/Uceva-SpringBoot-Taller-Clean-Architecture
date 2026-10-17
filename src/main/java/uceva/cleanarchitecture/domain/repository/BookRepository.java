package uceva.cleanarchitecture.domain.repository;

import uceva.cleanarchitecture.domain.entity.Book;
import java.util.List;

/**
 * Contrato del repositorio de libros.
 *
 * Pertenece a la capa de Domain y define las operaciones que
 * deben cumplir las implementaciones de repositorios de libros,
 * sin depender de detalles de infraestructura.
 */
public abstract class BookRepository {

    /**
     * Obtiene un listado de libros.
     *
     * @param countBooks cantidad de libros a obtener
     * @return lista de {@link Book}
     */
    public abstract List<Book> getAll(int countBooks);
}
