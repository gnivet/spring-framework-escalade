package org.springframework.samples.escalade.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {


	/*http://localhost:8080/test?name=Enora */

	@GetMapping(value = "/test")
	public String testform (@RequestParam(required=false, defaultValue ="World")  String name, ModelMap modelMap) {
		/*String  name = request.getParameter("name") != null && !request.getParameter("name").isEmpty()
				?request.getParameter("name"):
					"world";
					*/
				modelMap.put("name", name);
				return "/tests/bonjour";
	}
}
