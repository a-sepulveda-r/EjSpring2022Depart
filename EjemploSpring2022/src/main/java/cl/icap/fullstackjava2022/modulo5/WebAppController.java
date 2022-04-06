package cl.icap.fullstackjava2022.modulo5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
	@RequestMapping("/")
	public String getHome() {
		return("index");
	}
	@RequestMapping("/departments_page")
	public String getDepartments() {
		return("departments");
	}


}
