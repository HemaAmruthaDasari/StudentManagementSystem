package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.springboot.Entity.Branch;

public interface BranchRepository extends JpaRepository<Branch,Long> {

}
