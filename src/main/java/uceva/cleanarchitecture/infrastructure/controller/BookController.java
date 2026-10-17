package uceva.cleanarchitecture.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import uceva.cleanarchitecture.application.usecase.GetAllBooksUseCase;
import uceva.cleanarchitecture.domain.entity.Book;
import java.util.List;

/**
 * Controlador REST para operaciones relacionadas con libros.
 *
 * Pertenece a la capa más externa (Frameworks & Drivers): recibe las
 * solicitudes HTTP y delega la lógica en {@link GetAllBooksUseCase}.
 * No contiene lógica de negocio.
 */
@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Operaciones sobre libros")
public class BookController {

    private final GetAllBooksUseCase getAllBooksUseCase;

    /**
     * Crea una nueva instancia del controlador de libros.
     *
     * @param getAllBooksUseCase caso de uso encargado de obtener el listado de libros
     */
    public BookController(GetAllBooksUseCase getAllBooksUseCase){
        this.getAllBooksUseCase = getAllBooksUseCase;
    }

    /**
     * Obtiene un listado de libros generados dinámicamente.
     *
     * @param countBooks cantidad de libros a generar
     * @return lista de {@link Book}
     */
    @GetMapping("/{countBooks}")
    @Operation(summary = "Obtener listado de libros", description = "Retorna una lista de libros generados dinámicamente según la cantidad solicitada.")
    @ApiResponse(responseCode = "200", description = "Lista de libros generados")
    @Parameter(description = "Cantidad de libros a generar", example = "10")
    public List<Book> getAll(@PathVariable int countBooks) {
        return getAllBooksUseCase.execute(countBooks);
    }
}
