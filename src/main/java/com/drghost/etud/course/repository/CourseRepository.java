package com.drghost.etud.course.repository;

import com.drghost.etud.course.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends MongoRepository<Course, Integer> {
    Optional<Course> getCourseById(Integer id);
    List<Course> findAll();
}
