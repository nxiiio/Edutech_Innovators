package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Inscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InscriptionRepository implements CrudInterface<Inscription> {
    private List<Inscription> repository = new ArrayList<>(List.of(
            new Inscription(1L, 1L, 1L),
            new Inscription(2L,2L, 2L),
            new Inscription(3L,3L, 3L),
            new Inscription(4L,1L, 3L),
            new Inscription(5L,3L, 2L)
    ));

    @Override
    public List<Inscription> findAll() {
        return repository;
    }

    @Override
    public Optional<Inscription> findById(Long id) {
        for (Inscription inscription : repository) {
            if (inscription.getId().equals(id)) {
                return Optional.of(inscription);
            }
        }
        return Optional.empty();
    }

    @Override
    public Inscription save(Inscription inscription) {
        repository.add(inscription);
        return inscription;
    }

    @Override
    public Optional<Inscription> update(Long id, Inscription inscriptionRequest) {
        int currentId = 0;
        for (Inscription inscription : repository) {
            if (inscription.getId().equals(id)) {
                repository.set(currentId, inscriptionRequest);
                return Optional.of(inscriptionRequest);
            }
            currentId++;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        for (Inscription inscription : repository) {
            if (inscription.getId().equals(id)) {
                repository.remove(inscription);
                return true;
            }
        }
        return false;
    }
}
