package com.example.springboot.Service;

import com.example.springboot.Dto.DepartmentDto;

public interface DepartmentService {
	
	public DepartmentDto createDepartment(DepartmentDto departmentDto);
	public DepartmentDto getDepartmentwithBranchAndStudent(long id);
	

}
