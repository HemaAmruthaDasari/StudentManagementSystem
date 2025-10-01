package com.example.springboot.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Dto.DepartmentDto;
import com.example.springboot.Entity.Department;
import com.example.springboot.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		
		Department department = modelMapper.map(departmentDto,Department.class);
		Department savedDepartment = departmentRepository.save(department);
		return modelMapper.map(savedDepartment,DepartmentDto.class) ;
	}

	@Override
	public DepartmentDto getDepartmentwithBranchAndStudent(long id) {
		Department department = departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department Not Fount"));
		DepartmentDto deptDto = modelMapper.map(department,DepartmentDto.class);
		
		deptDto.getBranches().forEach(branch->{branch.getStudents().size();
	});
	return deptDto;
	}

}
