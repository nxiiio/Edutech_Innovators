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
        return List.of();
    }

    @Override
    public Optional<Instructor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Instructor save(Instructor entity) {
        return null;
    }

    @Override
    public Optional<Instructor> update(Long id, Instructor entity) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
