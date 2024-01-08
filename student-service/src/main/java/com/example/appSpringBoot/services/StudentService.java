package com.example.appSpringBoot.services;

import com.example.appSpringBoot.model.Student;
import com.example.appSpringBoot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Get the students list
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Add the student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(int id) { studentRepository.deleteById(id);}

    public Student updateStudent(Student updatedStudent, int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();

            // Update the existing student's information with the new values
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setEmail(updatedStudent.getEmail());

            // Save the updated student in the database
            return studentRepository.save(existingStudent);
        } else {
            // Handle the case when the student with the given ID is not found
            // You can throw an exception, return null, or handle it as needed
            // For example:
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }

    public Student getStudentById(int id) {
        // Implement logic to fetch student from your database or repository
        // This is a placeholder, replace it with your actual data retrieval logic
        return studentRepository.findById(id).orElse(null);
    }


//    public Department
//    updateDepartment(Department department,
//                     Long departmentId)
//    {
//        Department depDB
//                = departmentRepository.findById(departmentId)
//                .get();
//
//        if (Objects.nonNull(department.getDepartmentName())
//                && !"".equalsIgnoreCase(
//                department.getDepartmentName())) {
//            depDB.setDepartmentName(
//                    department.getDepartmentName());
//        }
//
//        if (Objects.nonNull(
//                department.getDepartmentAddress())
//                && !"".equalsIgnoreCase(
//                department.getDepartmentAddress())) {
//            depDB.setDepartmentAddress(
//                    department.getDepartmentAddress());
//        }
//
//        if (Objects.nonNull(department.getDepartmentCode())
//                && !"".equalsIgnoreCase(
//                department.getDepartmentCode())) {
//            depDB.setDepartmentCode(
//                    department.getDepartmentCode());
//        }
//
//        return departmentRepository.save(depDB);
//    }
}
