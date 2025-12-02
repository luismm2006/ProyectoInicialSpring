package com.Luis.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Luis.Service.ServiceCalc;

@Controller
public class ControllerSum {

	@Autowired
	private ServiceCalc serviceCalc;
	
	
	@GetMapping({ "/form", "/" })
	public String showForm() {
		return "formularioNumeros";
	}

	@PostMapping("/")
	public String showForm(@RequestParam Optional<String> sum1, @RequestParam Optional<String> sum2, @RequestParam Optional<String> operator, Model model) {
		try {
			int result = serviceCalc.operation(sum1, sum2, operator);
			
			if (sum1.isPresent() && sum2.isPresent()) {
				model.addAttribute("num1", sum1.get());
				model.addAttribute("num2", sum2.get());
				model.addAttribute("operation", operator.get());
				model.addAttribute("sum", result);
			}
		}catch(Exception e) {
			model.addAttribute("error", "Valores no válidos");
		}
		return "formularioNumeros";

	}
}
