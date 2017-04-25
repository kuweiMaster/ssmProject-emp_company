package com.kuwei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuwei.dto.Company;
import com.kuwei.dto.Emp;
import com.kuwei.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Resource(name="empService")
	private EmpService empService;
	
	@RequestMapping("/list.co")
	public String list(HttpServletRequest request){
		List<Emp> list = empService.getList();
		request.setAttribute("list", list);
		return "emp_list";
	}
	@RequestMapping("/deleteEmp.co")
	public String deleteEmp(Emp emp){
		empService.deleteEmp(emp);
		return "redirect:list.co";
	}
	/**
	 * 功能:
	 * 跳转添加页面
	 * @kuwei 2017年4月25日下午2:01:49
	 */
	@RequestMapping("/add.co")
	public String add(Emp emp,Integer[] ids){
		empService.saveEmp(emp,ids);
		return "redirect:list.co";
	}
	/**
	 * 功能:使用Ajax做法
	 * 跳转添加页面
	 * @kuwei 2017年4月25日下午2:01:49
	 */
	@RequestMapping("/toAdd.co")
	public String toAdd(){
		return "emp_add";
	}
	/**
	 * 功能:使用Ajax做法
	 * 获得复选框数据
	 * @kuwei 2017年4月25日下午2:01:49
	 */
	@ResponseBody
	@RequestMapping("/getCompanyList.co")
	public List<Company> getCompanyList(){
		List<Company> list = empService.getCompanyList();
		return list;
	}
	
	
	/**
	 * 功能:不用Ajax做法
	 * @kuwei 2017年4月25日下午2:01:32
	 */
	@RequestMapping("/toUpdate.co")
	public String toUpdate(HttpServletRequest request,Emp emp){
		Emp emp2 = empService.getEmpById(emp);
		List<Company> list = empService.getCompanyList();
		List<Integer> comList = empService.getCompanyListById(emp);
		request.setAttribute("list", list);
		request.setAttribute("comList", comList);
		request.setAttribute("emp2", emp2);
		return "emp_update";
	}
	@RequestMapping("/update.co")
	public String update(Emp emp,Integer[] ids){
		empService.updateInfo(emp,ids);
		return "redirect:list.co";
	}

	/**
	 * 功能:getters and setters
	 * @kuwei 2017年4月25日下午1:46:28
	 */
	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
}
