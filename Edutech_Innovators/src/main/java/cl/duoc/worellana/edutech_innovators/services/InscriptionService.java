package cl.duoc.worellana.edutech_innovators.services;

import cl.duoc.worellana.edutech_innovators.domain.Client;
import cl.duoc.worellana.edutech_innovators.domain.Course;
import cl.duoc.worellana.edutech_innovators.domain.Inscription;
import cl.duoc.worellana.edutech_innovators.dto.InscriptionDetailsDto;
import cl.duoc.worellana.edutech_innovators.repository.ClientRepository;
import cl.duoc.worellana.edutech_innovators.repository.CourseRepository;
import cl.duoc.worellana.edutech_innovators.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CourseRepository courseRepository;


    public List<InscriptionDetailsDto> getAllInscriptions(){
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        List<InscriptionDetailsDto> details = new ArrayList<>();

        for (Inscription ins : inscriptions){
            Optional<Client> client = clientRepository.findById(ins.getClientId());
            Optional<Course> course = courseRepository.findById(ins.getCourseId());

            if (client.isPresent() && course.isPresent()){
                details.add(new InscriptionDetailsDto(
                        ins.getId(),
                        client.get().getNome(),
                        course.get().getNameCourse()
                ));
            }
        }
        return details;
    }

    public Optional<InscriptionDetailsDto> getInscription(Long id){
        Optional<Inscription> found = inscriptionRepository.findById(id);

        if (found.isPresent()) {
            Inscription inscription = found.get();

            Optional<Client> client = clientRepository.findById(inscription.getClientId());
            Optional<Course> course = courseRepository.findById(inscription.getCourseId());

            if (client.isPresent() && course.isPresent()) {
                InscriptionDetailsDto result = new InscriptionDetailsDto(
                        inscription.getId(),
                        client.get().getNome(),
                        course.get().getNameCourse()
                );
                return Optional.of(result);
            }
        }

        return Optional.empty();
    }

    public boolean addInscription(Inscription inscriptionRequest){
        Optional<Client> client = clientRepository.findById(inscriptionRequest.getClientId());
        Optional<Course> course = courseRepository.findById(inscriptionRequest.getCourseId());
        Optional<Inscription> exits = inscriptionRepository.findById(inscriptionRequest.getId());

        if (client.isPresent() && course.isPresent() && exits.isEmpty()) {
            inscriptionRepository.save(inscriptionRequest);
            return true;
        }
        return false;
    }

    public boolean deleteInscription(Long id){
        Optional<Inscription> inscriptionFound = inscriptionRepository.findById(id);

        if (inscriptionFound.isPresent()){
            inscriptionRepository.delete(inscriptionFound.get());
            return true;
        }
        return false;
    }
    public boolean updateInscription(Inscription inscriptionRequest){
        return inscriptionRepository.update(inscriptionRequest);
    }
}
