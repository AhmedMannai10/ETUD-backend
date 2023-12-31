package com.drghost.etud.course.service.impl;

import com.drghost.etud.course.entities.Course;
import com.drghost.etud.course.repository.CourseRepository;
import com.drghost.etud.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void createCourse(Course newCourse) {
        courseRepository.save(newCourse);
    }
}
