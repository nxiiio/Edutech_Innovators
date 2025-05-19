package cl.duoc.worellana.edutech_innovators.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    Long id;
    String nameCourse;
    String descriptionCourse;

}
