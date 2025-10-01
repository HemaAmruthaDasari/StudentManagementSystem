package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Dto.BranchDto;
import com.example.springboot.Service.BranchService;

@RestController
@RequestMapping("/Branch")
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/addBranch/{id}")
	public ResponseEntity<BranchDto> createBranch(@PathVariable(name="id") long id,@RequestBody BranchDto branchdto)
	{
		return new ResponseEntity<>(branchService.createBranch(id, branchdto),HttpStatus.CREATED);
	}

}
