package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Inscription;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
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
    public boolean update(Inscription inscriptionRequest) {
        for (Inscription inscription : repository) {
            if (inscription.getId().equals(inscriptionRequest.getId())) {
                inscription.setClientId(inscriptionRequest.getClientId());
                inscription.setCourseId(inscriptionRequest.getCourseId());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Inscription inscriptionRequest) {
        return repository.remove(inscriptionRequest);
    }
}
