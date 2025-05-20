package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository implements CrudInterface<Course> {

    List<Course> repository = new ArrayList<>(List.of(
            new Course(1L, "Curso de Java", "Este curso de Java está diseñado para llevarte desde los fundamentos básicos\n" +
                                                                        "hasta conceptos avanzados de programación orientada a objetos. Aprenderás a \n" +
                                                                        "desarrollar aplicaciones robustas y escalables utilizando uno de los lenguajes \n" +
                                                                        "más demandados en la industria del software."),

            new Course(2L, "Curso de Python", "Este curso de Python está diseñado para enseñarte desde cero los fundamentos de la programación,\n " +
                                                                          "hasta que seas capaz de desarrollar tus propias aplicaciones y automatizaciones. "),

            new Course(3L, "Curso de Excel", "Este curso de Excel está diseñado para enseñarte desde los conceptos básicos hasta herramientas" +
                                                                        "avanzadas que te permitirán analizar, organizar y visualizar datos de forma eficiente.")
    ));

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
