package cl.duoc.worellana.edutech_innovators.services;

import cl.duoc.worellana.edutech_innovators.domain.Course;
import cl.duoc.worellana.edutech_innovators.domain.Instructor;
import cl.duoc.worellana.edutech_innovators.dto.InstructorDetailsDto;
import cl.duoc.worellana.edutech_innovators.repository.CourseRepository;
import cl.duoc.worellana.edutech_innovators.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<InstructorDetailsDto> getInstructors(){
        List<Instructor> instructors = instructorRepository.findAll();
        List<InstructorDetailsDto> details = new ArrayList<>();

        for (Instructor ins : instructors){
            Optional<Course> course = courseRepository.findById(ins.getIdCourse());

            if (course.isPresent()){
                details.add(new InstructorDetailsDto(
                        ins.getId(),
                        ins.getName(),
                        ins.getEmail(),
                        ins.getSpecialization(),
                        course.get().getNameCourse()
                ));
            }
        }
        return details;
    }

    public Optional<InstructorDetailsDto> getInstructor(Long id){
        Optional<Instructor> found = instructorRepository.findById(id);

        if (found.isPresent()){
            Optional<Course> course = courseRepository.findById(found.get().getIdCourse());
            InstructorDetailsDto result = new InstructorDetailsDto(
                    found.get().getId(),
                    found.get().getName(),
                    found.get().getEmail(),
                    found.get().getSpecialization(),
                    course.get().getNameCourse()
            );
            return Optional.of(result);
        }
        return Optional.empty();
    }

    public boolean addInstructor(Instructor instructorRequest){
        Optional<Course> course = courseRepository.findById(instructorRequest.getIdCourse());
        Optional<Instructor> exits = instructorRepository.findById(instructorRequest.getId());

        if (course.isPresent() && exits.isEmpty()){
            instructorRepository.save(instructorRequest);
            return true;
        }
        return false;
    }

    public boolean deleteInstructor(Long id){
        Optional<Instructor> instructorFound = instructorRepository.findById(id);

        if (instructorFound.isPresent()){
            instructorRepository.delete(instructorFound.get());
            return true;
        }
        return false;
    }

    public boolean updateInstructor(Instructor instructorRequest){
        return instructorRepository.update(instructorRequest);
    }
}
