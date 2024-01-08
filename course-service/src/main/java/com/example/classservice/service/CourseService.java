package com.example.classservice.service;

import com.example.classservice.model.Course;
import com.example.classservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Méthode pour récupérer tous les cours
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Méthode pour récupérer un cours par son ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Méthode pour enregistrer un nouveau cours
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Méthode pour supprimer un cours par son ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
