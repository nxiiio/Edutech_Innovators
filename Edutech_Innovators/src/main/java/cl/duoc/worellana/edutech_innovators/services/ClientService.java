package cl.duoc.worellana.edutech_innovators.services;

import cl.duoc.worellana.edutech_innovators.domain.Client;
import cl.duoc.worellana.edutech_innovators.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> getClients() {
        return repository.findAll();
    }

    public Optional<Client> getClient(Long id) {
        return repository.findById(id);
    }

    public boolean addClient(Client client) {
        if (repository.findById(client.getId()).isEmpty()) {
            repository.save(client);
            return true;
        }
        return false;
    }

    public boolean updateClient(Client client) {
        return repository.update(client);
    }

    public boolean deleteClient(Long id) {
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()) {
            repository.delete(client.get());
            return true;
        }

        return false;
    }
}
