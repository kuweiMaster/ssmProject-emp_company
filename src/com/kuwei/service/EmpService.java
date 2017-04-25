package com.kuwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuwei.dao.EmpDao;
import com.kuwei.dto.Company;
import com.kuwei.dto.Emp;

@Transactional
@Service("empService")
public class EmpService {

	@Resource(name="empDao")
	private EmpDao empDao;

	public List getList() {
		return empDao.getList();
	}

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public Emp getEmpById(Emp emp) {
		return empDao.getEmpById(emp);
	}

	public List<Company> getCompanyList() {
		return empDao.getCompanyList();
	}

	public List<Integer> getCompanyListById(Emp emp) {
		return empDao.getCompanyListById(emp);
	}

	public void updateInfo(Emp emp, Integer[] ids) {
		//修改emp基本信息
		empDao.updateEmp(emp);
		
		//删除中间表信息
		empDao.deleteMid(emp);
		
		//批量新增到中间表
		empDao.insertMid(emp,ids);
	}

	public void saveEmp(Emp emp, Integer[] ids) {
		//保存对象
		empDao.saveEmp(emp);
		//保存中间关系
		empDao.insertMid(emp, ids);
	}

	public void deleteEmp(Emp emp) {
		//删除中间关系
		empDao.deleteMid(emp);
		//删除基本信息
		empDao.deleteEmp(emp);
	}
	
}
