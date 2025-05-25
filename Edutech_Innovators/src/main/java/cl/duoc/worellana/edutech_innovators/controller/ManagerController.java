package cl.duoc.worellana.edutech_innovators.controller;

import cl.duoc.worellana.edutech_innovators.domain.Course;
import cl.duoc.worellana.edutech_innovators.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
