package com.example.springboot.Service;

import java.util.List;

import com.example.springboot.Dto.StudentDto;
import com.example.springboot.Entity.Student;


public interface StudentService {
	
	public StudentDto  createStudent(long id ,StudentDto studentdto);
	
	public List<StudentDto> getStudentByDeptAndBranchId(long deptid,long branchid);

}
