package cl.duoc.worellana.edutech_innovators.controller;

import cl.duoc.worellana.edutech_innovators.domain.Instructor;
import cl.duoc.worellana.edutech_innovators.dto.InstructorDetailsDto;
import cl.duoc.worellana.edutech_innovators.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    @Autowired
    InstructorService service;

    @GetMapping
    public ResponseEntity<List<InstructorDetailsDto>> showInstructors(){
        return ResponseEntity.ok(service.getInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDetailsDto> showInstructor(@PathVariable Long id){
        Optional<InstructorDetailsDto> found = service.getInstructor(id);

        if (found.isPresent()){
            return ResponseEntity.ok(found.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Instructor> postInstructor(@RequestBody Instructor request){
        boolean result = service.addInstructor(request);

        if (result){
            return ResponseEntity.status(HttpStatus.CREATED).body(request);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> replaceInstructor(@PathVariable Long id, @RequestBody Instructor request){
        request.setId(id);
        boolean result = service.updateInstructor(request);

        if (result){
            return ResponseEntity.ok(request);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable Long id){
        boolean result = service.deleteInstructor(id);

        if (result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
