package cl.duoc.worellana.edutech_innovators.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    Long id;
    String name;
    String email;
    boolean active;
}
