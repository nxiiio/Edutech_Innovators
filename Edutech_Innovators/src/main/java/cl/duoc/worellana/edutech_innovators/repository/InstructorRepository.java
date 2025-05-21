package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorRepository implements CrudInterface<Instructor> {

    List<Instructor> repository = new ArrayList<>(List.of(
            new Instructor(1L, "Gabriela Ramírez", "gabriela.ramirez@example.com", "Matemáticas"),
            new Instructor(2L, "Tomás Valenzuela", "tomas.valenzuela@example.com", "Programación Java"),
            new Instructor(3L, "Natalia Pino", "natalia.pino@example.com", "Bases de Datos"),
            new Instructor(4L, "Sebastián Muñoz", "sebastian.munoz@example.com", "Desarrollo Web")
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
    public Optional<Instructor> update(Long id, Instructor instructorRequest) {
        int currentId = 0;
        for (Instructor instructor : repository) {
            if (instructor.getId().equals(id)) {
                repository.set(currentId, instructorRequest);
                return Optional.of(instructorRequest);
            }
            currentId++;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        for (Instructor instructor : repository) {
            if (instructor.getId().equals(id)) {
                repository.remove(instructor);
                return true;
            }
        }
        return false;
    }
}
