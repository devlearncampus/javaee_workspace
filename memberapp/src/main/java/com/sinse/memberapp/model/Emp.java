package com.sinse.memberapp.model;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private Dept dept;
}





