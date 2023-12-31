package com.drghost.etud.course.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "_chapters")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Chapter {
    @Id
    @Transient
    private Integer id;

    @NotBlank
    private String name;

    private Lesson[] lectures;
}
