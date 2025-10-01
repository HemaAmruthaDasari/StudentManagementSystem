package com.example.springboot.Entity;

import jakarta.persistence.Entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String branchName;
    private int roomNo;
    private String section;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="deptId")
    private Department department;
    
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
    
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Branch(long id, String branchName, int roomNo, String section, Department department) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.roomNo = roomNo;
		this.section = section;
		this.department = department;
	}
	public Branch() {
		
	}
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
    
}
