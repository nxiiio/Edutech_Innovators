package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements CrudInterface<Client>{

    private List<Client> repository = new ArrayList<>(List.of(
            new Client(1L, "Luis Herrera", "luis.herrera@example.com",19L),
            new Client(2L, "Valentina Rojas", "valentina.rojas@example.com", 20L),
            new Client(3L, "Ignacio Torres", "ignacio.torres@example.com", 43L)
    ));

    @Override
    public List<Client> findAll() {
        return repository;
    }

    @Override
    public Optional<Client> findById(Long id) {
        for (Client client : repository){
            if (client.getId().equals(id)){
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    @Override
    public Client save(Client client) {
        repository.add(client);
        return client;
    }

    @Override
    public boolean update(Long id, Client clientRequest) {
        for (Client client : repository){
            if (client.getId().equals(id)){
                client.setNome(clientRequest.getNome());
                client.setEmail(clientRequest.getEmail());
                client.setAge(clientRequest.getAge());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Client clientRequest) {
        return repository.remove(clientRequest);
    }
}
