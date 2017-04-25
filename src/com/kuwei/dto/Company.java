package com.kuwei.dto;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Company implements java.io.Serializable {

	// Fields

	private Integer id;
	private String company;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(String company) {
		this.company = company;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}