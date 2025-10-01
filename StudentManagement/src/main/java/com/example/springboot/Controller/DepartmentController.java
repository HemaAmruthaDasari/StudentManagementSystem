package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Dto.DepartmentDto;
import com.example.springboot.Service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/addDept")
	public ResponseEntity<DepartmentDto> createDept(@RequestBody DepartmentDto departmentDto) throws Exception
	{
		return new ResponseEntity<>(departmentService.createDepartment(departmentDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getDetailsByDeptId/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        DepartmentDto deptDto = departmentService.getDepartmentwithBranchAndStudent(id);
        return ResponseEntity.ok(deptDto);
    } 

}
