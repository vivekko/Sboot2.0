package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
//        Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());
//        if(studentByEmail.isPresent()){
//            throw new IllegalStateException("email taken");
//        }
        studentRepository.save(student);
        System.out.println(student);
    }


    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) throw new IllegalStateException();
        studentRepository.deleteById(studentId);

    }
    @Transactional //Entity goes to managed state
    public void updateStudent(Long studentId,String name,String email){
//        boolean exists = studentRepository.existsById(studentId);
        Student student = studentRepository.getById(studentId);

//        if(!exists) throw new IllegalStateException();
//        studentRepository.deleteById(studentId);
//        if(name.length() > 0 && !Objects.equals(student.getName(),name))
            student.setName(name);

//        if(email.length() > 0 && !Objects.equals(student.getEmail(),email))
            student.setEmail(email);


    }

}