package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements CrudInterface<Client>{

    private List<Client> repository = new ArrayList<>(List.of(
            new Client(1L, "Luis Herrera", "luis.herrera@example.com"),
            new Client(2L, "Valentina Rojas", "valentina.rojas@example.com"),
            new Client(3L, "Ignacio Torres", "ignacio.torres@example.com")
    ));

    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Client save(Client entity) {
        return null;
    }

    @Override
    public Optional<Client> update(Long id, Client entity) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
