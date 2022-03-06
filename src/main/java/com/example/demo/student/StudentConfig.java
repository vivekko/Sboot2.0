package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Vivek = new Student(
//                    1L,
                    "Vivek Ojha",
                    LocalDate.of(2000, 10, 18),
                    "vivek.ojha@turtlemint.com"
//                    21
            );
            Student Jihyo = new Student(
//                    1L,
                    "Park Jihyo",
                    LocalDate.of(2000, 10, 18),
                    "jihyo.park@jyp.com"
//                    21
            );

//            repository.saveAll(
//                    List.of(Vivek,Jihyo)
//            );


        };

    }

}
