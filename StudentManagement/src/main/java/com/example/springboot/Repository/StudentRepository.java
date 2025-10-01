package com.example.springboot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.springboot.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	Optional<Student> findByEmail(String email);
}
