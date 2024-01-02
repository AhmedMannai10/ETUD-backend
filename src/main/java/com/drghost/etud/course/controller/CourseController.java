package com.drghost.etud.course.controller;

import com.drghost.etud.course.entities.Course;
import com.drghost.etud.course.entities.Lesson;
import com.drghost.etud.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourses(){
       return ResponseEntity.ok(courseService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<String> createCourse(@RequestBody Course course){

        try{
            System.out.println();
            courseService.createCourse(course);
            return ResponseEntity.ok("Course Created Successfully");
        }catch (IllegalStateException ex){
            throw ex;
        }
    }

}
