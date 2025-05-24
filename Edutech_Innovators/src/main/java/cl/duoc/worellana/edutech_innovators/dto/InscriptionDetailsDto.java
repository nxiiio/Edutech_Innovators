package cl.duoc.worellana.edutech_innovators.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionDetailsDto {
    Long inscriptionId;
    String clientName;
    String courseName;
}
