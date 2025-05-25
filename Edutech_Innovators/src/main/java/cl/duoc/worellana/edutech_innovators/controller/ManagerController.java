package cl.duoc.worellana.edutech_innovators.controller;

import cl.duoc.worellana.edutech_innovators.domain.Course;
import cl.duoc.worellana.edutech_innovators.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    @Autowired
    CourseService service;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> showCourses(){
        return ResponseEntity.ok(service.getCourses());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> showCourse(@PathVariable Long id){
        Optional<Course> course = service.getCourse(id);

        if (course.isPresent()){
            return ResponseEntity.ok(course.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course request){
        boolean result = service.addCourse(request);

        if (result){
            return ResponseEntity.status(HttpStatus.CREATED).body(request);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> replaceCourse(@PathVariable Long id, @RequestBody Course request){
        boolean result = service.updateCourse(request);

        if (result){
            return ResponseEntity.ok(request);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        boolean result = service.deleteCourse(id);

        if (result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
