package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.springboot.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
