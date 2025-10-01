package com.example.springboot.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.springboot.Dto.StudentDto;
import com.example.springboot.Entity.Branch;
import com.example.springboot.Entity.Department;
import com.example.springboot.Entity.Student;
import com.example.springboot.Repository.BranchRepository;
import com.example.springboot.Repository.DepartmentRepository;
import com.example.springboot.Repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public StudentDto createStudent(long id,StudentDto studentDto) {
		Branch branch = branchRepository.findById(id).get();
		Student student=modelMapper.map(studentDto,Student.class);
		student.setBranch(branch);
		   student.setPassword(passwordEncoder.encode(student.getPassword()));
		Student savedStudent=studentRepository.save(student);
		return modelMapper.map(savedStudent,StudentDto.class);
		
		
		
	}


	@Override
	public List<StudentDto> getStudentByDeptAndBranchId(long deptid,long branchid) {
		 Department department = departmentRepository.findById(deptid)
	                .orElseThrow(() -> new RuntimeException("Department not found"));
		 Branch branch =department.getBranches().stream().filter(b->b.getId() == branchid).findFirst().orElseThrow(()->new RuntimeException("Branch not found "));
		 List<Student> students= branch.getStudents();
		 List<StudentDto> studentDtos = modelMapper.map(
		            students,
		            new org.modelmapper.TypeToken<List<StudentDto>>() {}.getType()
		    );

		    return studentDtos;
	}

	

}
