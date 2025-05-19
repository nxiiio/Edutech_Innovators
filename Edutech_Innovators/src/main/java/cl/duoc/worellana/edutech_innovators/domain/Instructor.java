package cl.duoc.worellana.edutech_innovators.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    Long id;
    String name;
    String email;
    String specialization;

}
