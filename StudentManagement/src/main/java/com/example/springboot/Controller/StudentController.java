package com.example.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.springboot.Dto.DepartmentDto;

import com.example.springboot.Dto.StudentDto;
import com.example.springboot.Service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	 
	@PostMapping("/addStudent/{id}")
	public ResponseEntity<StudentDto> createStudent(@PathVariable(name="id") long id , @RequestBody StudentDto studentDto)
	{
		return new ResponseEntity<>(studentService.createStudent(id, studentDto),HttpStatus.CREATED);
	}
	
		
	@GetMapping("getStudents/dept/{deptid}/branch/{branchid}")
	public ResponseEntity<List<StudentDto>> getStudentByDeptAndBranchId(@PathVariable long deptid,
	                                                                   @PathVariable long branchid) {
	    List<StudentDto> studentDtos = studentService.getStudentByDeptAndBranchId(deptid, branchid);
	    return ResponseEntity.ok(studentDtos);
	}

	

}
