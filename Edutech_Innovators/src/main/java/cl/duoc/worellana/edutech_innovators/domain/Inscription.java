package cl.duoc.worellana.edutech_innovators.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscription {
    Long id;
    String nameInscription;
    Long clientId;
    Long courseId;
    Integer calification;
}
