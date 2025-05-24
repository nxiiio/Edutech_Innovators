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
                                                                        "avanzadas que te permitirán analizar, organizar y visualizar datos de forma eficiente."),

            new Course(4L, "Curso de Desarrollo Web", "Aprende HTML, CSS y JavaScript para crear sitios web interactivos y responsivos desde cero."),

            new Course(5L, "Curso de Ciberseguridad", "Conoce los fundamentos de la ciberseguridad, detección de amenazas, y buenas prácticas para proteger sistemas."),

            new Course(6L, "Curso de Bases de Datos", "Aprende SQL y diseño de bases de datos relacionales utilizando MySQL o PostgreSQL."),

            new Course(7L, "Curso de Spring Boot", "Domina el desarrollo de aplicaciones web robustas usando Spring Boot y el ecosistema de Spring."),

            new Course(8L, "Curso de Comunicación Efectiva", "Mejora tus habilidades para presentar ideas, comunicarte en equipos y negociar en ambientes laborales."),

            new Course(9L, "Curso de Inglés Técnico", "Enfocado en mejorar el inglés para el entorno tecnológico y profesional, incluyendo lectura y escritura de documentación técnica.")

            ));

    @Override
    public List<Course> findAll() {
        return repository;
    }

    @Override
    public Optional<Course> findById(Long id) {
        for (Course course : repository) {
            if (course.getId().equals(id)) {
                return Optional.of(course);
            }
        }
        return Optional.empty();
    }

    @Override
    public Course save(Course course) {
        repository.add(course);
        return course;
    }

    @Override
    public boolean update(Course courseRequest) {
        for (Course course : repository) {
            if (course.getId().equals(courseRequest.getId())) {
                course.setNameCourse(courseRequest.getNameCourse());
                course.setDescriptionCourse(courseRequest.getDescriptionCourse());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Course courseRequest) {
        return repository.remove(courseRequest);
    }
}
