package uceva.cleanarchitecture.application.usecase;

import uceva.cleanarchitecture.domain.entity.Course;
import uceva.cleanarchitecture.domain.repository.CourseRepository;

import java.util.List;

public class GetAllCoursesUseCase {
    private final CourseRepository courseRepository;

    public GetAllCoursesUseCase(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> execute(int countCourses){
        return courseRepository.getAll(countCourses);
    }
}
