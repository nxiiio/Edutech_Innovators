package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Inscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InscriptionRepository implements CrudInterface<Inscription> {
    private List<Inscription> repository = new ArrayList<>(List.of(
            new Inscription(1L, "Inscripción Java - Luis", 1L, 1L),
            new Inscription(2L, "Inscripción Python - Valentina", 2L, 2L),
            new Inscription(3L, "Inscripción Excel - Ignacio", 3L, 3L),
            new Inscription(4L, "Inscripción Excel - Luis", 1L, 3L),
            new Inscription(5L, "Inscripción Python - Ignacio", 3L, 2L)
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
    public boolean update(Long id, Inscription inscriptionRequest) {
        for (Inscription inscription : repository) {
            if (inscription.getId().equals(id)) {
                inscription.setNameInscription(inscriptionRequest.getNameInscription());
                inscription.setClientId(inscriptionRequest.getClientId());
                inscription.setCourseId(inscriptionRequest.getCourseId());
                return true;
            }
        }
        return false;
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
