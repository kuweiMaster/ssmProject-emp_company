package com.kuwei.dto;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Emp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double salary;
	
	private String company;
	private Integer comNum;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	public Emp(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getComNum() {
		return comNum;
	}

	public void setComNum(Integer comNum) {
		this.comNum = comNum;
	}

}