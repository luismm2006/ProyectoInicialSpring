package com.Luis.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerSum {

	@GetMapping({"/form" , "/"})
	public String showForm() {
		return "formularioNumeros";
	}
	
	@GetMapping("/sum")
	public String suma(@RequestParam Optional<Integer> sum1, @RequestParam Optional<Integer> sum2 , Model model) {
		if(sum1.isPresent() && sum2.isPresent()) {
			model.addAttribute("num1", sum1.get());
			model.addAttribute("num2", sum2.get());
			model.addAttribute("sum", sum1.get()+sum2.get());
		}
		return "resultadoNumeros";
		
	}
}
