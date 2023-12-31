package com.drghost.etud.course.service;


import com.drghost.etud.course.entities.Course;
import com.drghost.etud.course.service.impl.CourseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {

    List<Course> getAll();

    void createCourse(Course newCourse);
}
