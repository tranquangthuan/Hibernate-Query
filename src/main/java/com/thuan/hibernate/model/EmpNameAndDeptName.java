package com.thuan.hibernate.model;

public class EmpNameAndDeptName {
	private String emptName;
	private String deptName;

	public EmpNameAndDeptName(String emptName, String deptName) {
		super();
		this.emptName = emptName;
		this.deptName = deptName;
	}

	public EmpNameAndDeptName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmptName() {
		return emptName;
	}

	public void setEmptName(String emptName) {
		this.emptName = emptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "EmpNameAndDeptName [emptName=" + emptName + ", deptName=" + deptName + "]";
	}

}
