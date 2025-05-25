package cl.duoc.worellana.edutech_innovators.controller;

import cl.duoc.worellana.edutech_innovators.domain.Inscription;
import cl.duoc.worellana.edutech_innovators.dto.InscriptionDetailsDto;
import cl.duoc.worellana.edutech_innovators.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inscriptions")
public class InscriptionController {

    @Autowired
    InscriptionService service;

    @GetMapping
    public ResponseEntity<List<InscriptionDetailsDto>> showInscriptions(){
        return ResponseEntity.ok(service.getAllInscriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDetailsDto> showInscription(@PathVariable Long id){
        Optional<InscriptionDetailsDto> inscription = service.getInscription(id);

        if (inscription.isPresent()){
            return ResponseEntity.ok(inscription.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InscriptionDetailsDto> postInscription(@RequestBody Inscription request){
        boolean result = service.addInscription(request);

        if (result){
            Optional<InscriptionDetailsDto> show = service.getInscription(request.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(show.get());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscriptionDetailsDto> replaceInscription(@PathVariable Long id, @RequestBody Inscription request){
        request.setId(id);
        boolean result = service.updateInscription(request);

        if (result){
            Optional<InscriptionDetailsDto> show = service.getInscription(id);
            return ResponseEntity.ok(show.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Inscription> deleteInscription(@PathVariable Long id){
        boolean result = service.deleteInscription(id);
        if (result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
