package com.example.springboot.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
public class BranchDto {

	 private long id;
	    private String branchName;
	    private int roomNo;
	    private String section;
	    
	    @JsonIgnore
		private DepartmentDto department;
	    private List<StudentDto> students;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public int getRoomNo() {
			return roomNo;
		}
		public void setRoomNo(int roomNo) {
			this.roomNo = roomNo;
		}
		public String getSection() {
			return section;
		}
		public void setSection(String section) {
			this.section = section;
		}
		 public DepartmentDto getDepartment() { return department; }
		    public void setDepartment(DepartmentDto department) { this.department = department; }

		    public List<StudentDto> getStudents() { return students; }
		    public void setStudents(List<StudentDto> students) { this.students = students; }
	}

