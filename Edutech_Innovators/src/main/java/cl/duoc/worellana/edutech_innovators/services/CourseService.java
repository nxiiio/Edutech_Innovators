package cl.duoc.worellana.edutech_innovators.services;

import cl.duoc.worellana.edutech_innovators.domain.Course;
import cl.duoc.worellana.edutech_innovators.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public List<Course> getCourses(){
        return repository.findAll();
    }

    public Optional<Course> getCourse(Long id){
        return repository.findById(id);
    }

    public boolean addCourse(Course courseRequest){
        if (repository.findById(courseRequest.getId()).isEmpty()){
            repository.save(courseRequest);
            return true;
        }
        return false;
    }

    public boolean updateCourse(Course courseRequest){
        return repository.update(courseRequest);
    }

    public boolean deleteCourse(Long id){
        Optional<Course> exits = repository.findById(id);

        if (exits.isPresent()){
            repository.delete(exits.get());
            return true;
        }
        return false;
    }


}
