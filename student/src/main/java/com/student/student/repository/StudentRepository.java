package com.student.student.repository;

import com.student.student.entity.Student;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Optional<Student> findByNisn(String nisn); 
}

