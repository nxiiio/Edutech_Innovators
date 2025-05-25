package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepository implements CrudInterface<Instructor> {

    List<Instructor> repository = new ArrayList<>(List.of(
            new Instructor(1L, "María González", "maria.gonzalez@example.com", "Programación en Java", 1L),
            new Instructor(2L, "Carlos Pérez", "carlos.perez@example.com", "Programación en Java", 1L),

            new Instructor(3L, "Ana Martínez", "ana.martinez@example.com", "Python y automatización", 2L),
            new Instructor(4L, "Diego Morales", "diego.morales@example.com", "Python para principiantes", 2L),

            new Instructor(5L, "Javier Soto", "javier.soto@example.com", "Excel avanzado", 3L),

            new Instructor(6L, "Laura Riquelme", "laura.riquelme@example.com", "Desarrollo Web", 4L),
            new Instructor(7L, "Tomás Vidal", "tomas.vidal@example.com", "Desarrollo Frontend", 4L),

            new Instructor(8L, "Patricia Ramírez", "patricia.ramirez@example.com", "Ciberseguridad", 5L),

            new Instructor(9L, "Ignacio Herrera", "ignacio.herrera@example.com", "Bases de Datos relacionales", 6L),

            new Instructor(10L, "Fernanda Díaz", "fernanda.diaz@example.com", "Spring Boot", 7L),

            new Instructor(11L, "Lorena Silva", "lorena.silva@example.com", "Comunicación Efectiva", 8L),

            new Instructor(12L, "Esteban Navarro", "esteban.navarro@example.com", "Inglés Técnico", 9L),
            new Instructor(13L, "Camila Vergara", "camila.vergara@example.com", "Inglés Técnico", 9L)
    ));

    @Override
    public List<Instructor> findAll() {
        return repository;
    }

    @Override
    public Optional<Instructor> findById(Long id) {
        for (Instructor instructor : repository) {
            if (instructor.getId().equals(id)) {
                return Optional.of(instructor);
            }
        }
        return Optional.empty();
    }

    @Override
    public Instructor save(Instructor instructor) {
        repository.add(instructor);
        return instructor;
    }

    @Override
    public boolean update(Instructor instructorRequest) {
        for (Instructor instructor : repository) {
            if (instructor.getId().equals(instructorRequest.getId())) {
                instructor.setName(instructorRequest.getName());
                instructor.setEmail(instructorRequest.getEmail());
                instructor.setSpecialization(instructorRequest.getSpecialization());
                instructor.setIdCourse(instructorRequest.getIdCourse());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Instructor instructorRequest) {
        return repository.remove(instructorRequest);
    }

}
