package uceva.cleanarchitecture.domain.entity;

/**
 * Entidad que representa un curso del sistema.
 *
 * @remarks
 * La facultad debe ser uno de los siguientes valores:
 * - "Ingenieria"
 * - "Ciencias"
 * - "Administracion"
 * - "Derecho"
 */
public class Course {
    public Integer id;
    public String name;
    public Integer credits;
    public String teacher;
    public String faculty;

    public Course(Integer id, String name, Integer credits, String teacher, String faculty) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
        this.faculty = faculty;
    }
}