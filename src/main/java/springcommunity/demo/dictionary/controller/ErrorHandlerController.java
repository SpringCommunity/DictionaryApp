package springcommunity.demo.dictionary.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController implements ErrorController {

	@RequestMapping(value = "/error")
	public String handleError(HttpServletResponse response, Model model) {
		int statusCode = response.getStatus();
		String status = "Oops. Something went wrong";
        model.addAttribute("code", statusCode);
        model.addAttribute("status", status);
		return "error";
	}

	@Override
	public String getErrorPath() {
		return null;
	}

}
