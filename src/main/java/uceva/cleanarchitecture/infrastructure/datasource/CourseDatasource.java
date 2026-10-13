package uceva.cleanarchitecture.infrastructure.datasource;

import com.github.javafaker.Faker;
import uceva.cleanarchitecture.domain.entity.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseDatasource {

    private Faker faker = new Faker();
    private final Random random = new Random();
    private final String[] faculties = {"Ingenieria", "Ciencias", "Administracion", "Derecho"};
    private final String[] courseNames = {
            "Programación Orientada a Objetos",
            "Bases de Datos",
            "Cálculo Diferencial",
            "Estructuras de Datos",
            "Redes de Computadores",
            "Arquitectura de Software",
            "Álgebra Lineal",
            "Física Mecánica",
            "Contabilidad Básica",
            "Derecho Constitucional",
            "Estadística",
            "Ingeniería de Requisitos"
    };

    public List<Course> getAll(int countCourses){
        List<Course> courses = new ArrayList<Course>();
        for (int i = 1; i <= countCourses; i++) {
            courses.add(generateCourse(i));
        }
        return courses;
    }

    private Course generateCourse(Integer id){
        String name = courseNames[random.nextInt(courseNames.length)];
        int credits = faker.number().numberBetween(1, 7); // upper bound exclusive
        String teacher = faker.name().fullName();
        String faculty = faculties[random.nextInt(faculties.length)];
        return new Course(id, name, credits, teacher, faculty);
    }
}
