package com.example.appSpringBoot.repositories;

import com.example.appSpringBoot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Save a Student
    Student save(Student student);

    // Find a Student by ID
    Optional<Student> findById(Integer id);

    // Get all Students
    List<Student> findAll();

    // Delete a Student by id
    void deleteById(Integer id);





}
