package com.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		//binder.setDisallowedFields(new String[]{"studentMobile"});
		SimpleDateFormat format = new SimpleDateFormat("YYYY****MM****DD");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(format, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
		
	}

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model = new ModelAndView("AdmissionForm");

		return model;
	}
	
	//@RequestMapping("/submitAdmissionForm.html")
	//public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name, @RequestParam("studentHobby") String hobby) {

//		ModelAndView model = new ModelAndView("AdmissionSuccess");
//		model.addObject("msg","Details submitted by you:: Name: "+name+ ", Hobby: " + hobby);

//		return model;
//	}
	
	@ModelAttribute
	private void addingCommonObjects(Model model){
		model.addAttribute("messageHeader", "Arvind College of Engineering");
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm( @Valid @ModelAttribute("student1") Student student1, BindingResult result) {
		
		if(result.hasErrors()){
			
			ModelAndView model1 = new ModelAndView("AdmissionForm");
			return model1;
			
		}
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		
		return model;
	}
}