package com.example.appSpringBoot.services;

import com.example.appSpringBoot.model.Student;
import com.example.appSpringBoot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {

    private final StudentRepository studentRepository;

    @Autowired
    public CSVReaderService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void init() {
        try {
            // Read the CSV file from the resources folder
            InputStream inputStream = getClass().getResourceAsStream("/students.csv");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            boolean headerSkipped = false;
            List<Student> students = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    // Skip the header line
                    headerSkipped = true;
                    continue;
                }

                String[] data = line.split(",\\s*"); // Split CSV line by comma

                // Create a Student object from the CSV data
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String email = data[3];

                Student student = new Student(id, name, age, email);
                students.add(student);
            }

            // Save students to the database via repository
            studentRepository.saveAll(students);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

