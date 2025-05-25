package cl.duoc.worellana.edutech_innovators.controller;

import cl.duoc.worellana.edutech_innovators.domain.Client;
import cl.duoc.worellana.edutech_innovators.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    ClientService service;


    @GetMapping("/clients")
    public ResponseEntity<List<Client>> showClients(){
        return ResponseEntity.ok(service.getClients());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> showClient(@PathVariable Long id){
        Optional<Client> found = service.getClient(id);

        if (found.isPresent()){
            return ResponseEntity.ok(found.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> postClient(@RequestBody Client request){
        boolean result = service.addClient(request);

        if (result){
            return ResponseEntity.status(HttpStatus.CREATED).body(request);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> replaceClient(@PathVariable Long id, @RequestBody Client request){
        request.setId(id);
        boolean result = service.updateClient(request);

        if (result){
            return ResponseEntity.ok(request);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id){
        boolean result = service.deleteClient(id);

        if (result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
