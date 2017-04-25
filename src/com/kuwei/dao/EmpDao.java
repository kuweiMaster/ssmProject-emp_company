package com.kuwei.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kuwei.dto.Company;
import com.kuwei.dto.Emp;
import com.kuwei.utils.MybatisUtils;

@Repository("empDao")
public class EmpDao {

	static SqlSession session;
	
	static {
		session = MybatisUtils.getSqlSessionFactory().openSession();
	}
	
	static Map<Object, Object> map = new HashMap<Object, Object>();

	public List getList() {
		return session.selectList("allList");
	}

	public Emp getEmpById(Emp emp) {
		map.put("id", emp.getId());
		return session.selectOne("getEmpById", map);
	}

	public List<Company> getCompanyList() {
		return session.selectList("companyList");
	}

	public List<Integer> getCompanyListById(Emp emp) {
		map.put("id", emp.getId());
		return session.selectList("companyListById",map);
	}

	public void deleteMid(Emp emp) {
		map.put("id", emp.getId());
		session.delete("deleteMid", map);
		session.commit();
	}

	public void insertMid(Emp emp, Integer[] ids) {
		map.put("id", emp.getId());
		map.put("ids", ids);
		session.insert("insertMid", map);
		session.commit();
	}

	public void updateEmp(Emp emp) {
		map.put("emp", emp);
		session.update("updateEmp", map);
		session.commit();
	}

	public void saveEmp(Emp emp) {
		session.insert("saveEmp", emp);
		session.commit();
	}

	public void deleteEmp(Emp emp) {
		map.put("id", emp.getId());
		session.delete("deleteEmp", map);
		session.commit();
	}
	
}
