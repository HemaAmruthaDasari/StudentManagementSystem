package com.example.springboot.Dto;

import java.util.List;

public class DepartmentDto {
	private long id;
	private String deptName;
	
	 private List<BranchDto> branches;
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

    public List<BranchDto> getBranches() { return branches; }
    public void setBranches(List<BranchDto> branches) { this.branches = branches; }
	

}
