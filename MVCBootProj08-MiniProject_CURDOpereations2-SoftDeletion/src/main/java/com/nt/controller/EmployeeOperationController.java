package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String,Object> map) {
		Iterable<Employee> itEmps=empService.getAllEmployees();
		map.put("empsList", itEmps);
		return "show_employee_report";
	}
	
	@GetMapping("/emp_add")
	public String showFormForsaveEmployee(@ModelAttribute("emp") Employee emp) {
		return "register_employee";
	}
	
	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
		String msg=empService.registerEmployee(emp);
		Iterable<Employee> itEmps=empService.getAllEmployees();
		map.put("resultMsg", msg);
		map.put("empsList", itEmps);
		return "show_employee_report";
	}*/
	
	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
		String msg=empService.registerEmployee(emp);
		map.put("resultMsg", msg);
		return "redirect:emp_report";
	}*/
	
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs) {
		String msg=empService.registerEmployee(emp);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:emp_report";
	}
	
	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,HttpSession ses) {
		String msg=empService.registerEmployee(emp);
		ses.setAttribute("resultMsg", msg);
		return "redirect:emp_report";
	}*/
	
	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam int no,@ModelAttribute("emp") Employee emp) {
		Employee emp1=empService.getEmployeeByNo(no);
		BeanUtils.copyProperties(emp1, emp);
		return "update_employee";
	}
	
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
		String msg=empService.updateEmployee(emp);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:emp_report";
	}
	
	@GetMapping("/emp_delete")
	public String deleteEmployee(RedirectAttributes attrs,@RequestParam int no) {
		String msg=empService.deleteEmployeeByID(no);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:emp_report";
	}
}
