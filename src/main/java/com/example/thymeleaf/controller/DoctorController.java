package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {

    @GetMapping("/doctor")
    public String doctor(Model model,
    		@RequestParam(value="name", required=false) String name, 
    		@RequestParam(value="number", required=false) String number) {
    	
    	if (name.length() == 0 && number.length() == 0) {
    		name = "John Doe";
    		number = "0";
    	} else {    	
    		if (name.length() == 0)
	    		name = "John Smith";
    		if (number.length() == 0)
	    		number = "0";	
    	}    	
 
    	model.addAttribute("doctorname", name);
    	model.addAttribute("doctornumber", number);
    	
        return "doctor";
    }
}
