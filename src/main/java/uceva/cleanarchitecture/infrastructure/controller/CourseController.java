package uceva.cleanarchitecture.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import uceva.cleanarchitecture.application.usecase.GetAllCoursesUseCase;
import uceva.cleanarchitecture.domain.entity.Course;
import java.util.List;

@RestController
@RequestMapping("/courses")
@Tag(name = "Courses", description = "Operaciones sobre cursos")
public class CourseController {

    private final GetAllCoursesUseCase getAllCoursesUseCase;

    public CourseController(GetAllCoursesUseCase getAllCoursesUseCase){
        this.getAllCoursesUseCase = getAllCoursesUseCase;
    }

    @GetMapping("/{countCourses}")
    @Operation(summary = "Obtener listado de cursos", description = "Retorna una lista de cursos generados dinámicamente según la cantidad solicitada.")
    @ApiResponse(responseCode = "200", description = "Lista de cursos generados")
    @Parameter(description = "Cantidad de cursos a generar", example = "10")
    public List<Course> getAll(@PathVariable int countCourses) {
        return getAllCoursesUseCase.execute(countCourses);
    }
}
