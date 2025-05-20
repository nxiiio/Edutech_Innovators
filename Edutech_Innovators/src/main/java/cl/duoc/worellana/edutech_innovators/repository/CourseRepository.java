package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository implements CrudInterface<Course>{

    @Override
    public List<Course> findAll() {
        return List.of();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Course save(Course entity) {
        return null;
    }

    @Override
    public Optional<Course> update(Long id, Course entity) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
