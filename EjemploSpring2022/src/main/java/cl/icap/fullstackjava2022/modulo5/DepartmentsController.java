package cl.icap.fullstackjava2022.modulo5;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.icap.fullstackjava2022.modulo5.model.dto.Departmentsdto;
import cl.icap.fullstackjava2022.modulo5.service.DepartmentsService;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {
	@Autowired
	private DepartmentsService departmentsservice;
	
	@RequestMapping("/list")
	public @ResponseBody List<Departmentsdto> list(HttpServletRequest request, HttpServletResponse response){
		return departmentsservice.list();
	}
	@RequestMapping("/select")
	public @ResponseBody Departmentsdto select(HttpServletRequest request, HttpServletResponse response ) {
		return departmentsservice.get(request.getParameter("dept_no"));
		
	}
	@RequestMapping("/delete") 
	public @ResponseBody int delete(HttpServletRequest request, HttpServletResponse response) {
		return departmentsservice.delete(request.getParameter("dept_no"));
	}
	
	@RequestMapping("/update") 
	public @ResponseBody int update(HttpServletRequest request, HttpServletResponse response) {
		return departmentsservice.update(new Departmentsdto(request.getParameter("dept_no"),request.getParameter("dept_name")));
	}
	
	@RequestMapping("/insert") 
	public @ResponseBody int insert(HttpServletRequest request, HttpServletResponse response) {
		return departmentsservice.insert(new Departmentsdto(request.getParameter("dept_no"),request.getParameter("dept_name")));
	}

}

