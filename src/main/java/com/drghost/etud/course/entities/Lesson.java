package com.drghost.etud.course.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "_lessons")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class Lesson {
    @NotBlank
    private String title;
    private String description;
    @NotBlank
    private String videoUrl;
}