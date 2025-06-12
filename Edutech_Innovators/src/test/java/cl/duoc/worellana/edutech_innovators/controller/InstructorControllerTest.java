package cl.duoc.worellana.edutech_innovators.controller;

import cl.duoc.worellana.edutech_innovators.dto.InstructorDetailsDto;
import cl.duoc.worellana.edutech_innovators.repository.InstructorRepository;
import cl.duoc.worellana.edutech_innovators.services.InstructorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorControllerTest {

    @Mock
    private InstructorService service;

    @InjectMocks
    private InstructorController controller;

    @Test
    void showInstructor() {
        // GIVEN
        Long request = 1L;
        ResponseEntity<InstructorDetailsDto> result = ResponseEntity.ok(new InstructorDetailsDto(
                1L,
                "María González",
                "maria.gonzalez@example.com",
                "Programación en Java",
                "Curso de java"));

        given(service.getInstructor(request)).willReturn(Optional.ofNullable(result.getBody()));

        // WHEN
        ResponseEntity<InstructorDetailsDto> method = controller.showInstructor(1L);

        // THEN
        assertNotNull(method);
        assertEquals(HttpStatusCode.valueOf(200), method.getStatusCode());


    }

}