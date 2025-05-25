package cl.duoc.worellana.edutech_innovators.repository;

import cl.duoc.worellana.edutech_innovators.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements CrudInterface<Client>{

    private List<Client> repository = new ArrayList<>(List.of(
            new Client(1L, "Luis Herrera", "luis.herrera@example.com", 19L),
            new Client(2L, "Valentina Rojas", "valentina.rojas@example.com", 20L),
            new Client(3L, "Ignacio Torres", "ignacio.torres@example.com", 43L),
            new Client(4L, "Camila Díaz", "camila.diaz@example.com", 25L),
            new Client(5L, "Matías González", "matias.gonzalez@example.com", 34L),
            new Client(6L, "Fernanda Salinas", "fernanda.salinas@example.com", 28L),
            new Client(7L, "Tomás Fuentes", "tomas.fuentes@example.com", 22L),
            new Client(8L, "Daniela Paredes", "daniela.paredes@example.com", 31L),
            new Client(9L, "Sebastián Morales", "sebastian.morales@example.com", 26L),
            new Client(10L, "Josefa Araya", "josefa.araya@example.com", 30L),
            new Client(11L, "Andrés Castro", "andres.castro@example.com", 35L),
            new Client(12L, "Paula Reyes", "paula.reyes@example.com", 27L)
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
    public boolean update(Client clientRequest) {
        for (Client client : repository){
            if (client.getId().equals(clientRequest.getId())){
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
