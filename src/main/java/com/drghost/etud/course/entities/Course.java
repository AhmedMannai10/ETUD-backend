package com.drghost.etud.course.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "_courses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @Transient
    private Integer  id;

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private String topics;
    // TODO: Add course teacher
    // private Teacher teacher
    private Chapter[]  chapters;
    // Each Chapter has a title and

    // add reviews;
    //


}
