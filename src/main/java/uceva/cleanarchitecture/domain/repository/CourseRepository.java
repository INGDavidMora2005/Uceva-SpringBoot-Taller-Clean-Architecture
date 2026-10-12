package uceva.cleanarchitecture.domain.repository;

import uceva.cleanarchitecture.domain.entity.Course;
import java.util.List;

public abstract class CourseRepository {
    public abstract List<Course> getAll(int countCourses);
}