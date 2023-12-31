package com.drghost.etud.course.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "_lessons")
@Builder
@AllArgsConstructor
public class Lesson {
    @Id
    @Transient
    private Integer id;
    @NotBlank
    private String title;
    private String description;
    @NotBlank
    private String videoUrl;
}