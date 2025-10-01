package com.example.springboot.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Dto.BranchDto;
import com.example.springboot.Entity.Branch;
import com.example.springboot.Entity.Department;
import com.example.springboot.Repository.BranchRepository;
import com.example.springboot.Repository.DepartmentRepository;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BranchDto createBranch(long id,BranchDto branchDto) {
		Department department = departmentRepository.findById(id).get();
		Branch branch = modelMapper.map(branchDto,Branch.class);
		branch.setDepartment(department);
		Branch savedBranch= branchRepository.save(branch);
		return modelMapper.map(savedBranch,BranchDto.class);
	}

}
