package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;



@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> liststudent =service.listAll();
		model.addAttribute("listStudent", liststudent);
		return "index";
	}
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "new";
	}
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student")Student stu) {
		service.save(stu);
		return "redirect:/";
	}
	@RequestMapping("edit/{studentId}")
	public ModelAndView editStu(@PathVariable(name="studentId") int id) {
		ModelAndView mv = new ModelAndView("new");
		Student s = service.get(id);
		mv.addObject("student", s);
		
		return mv;
		
	}
	@RequestMapping("delete/{studentId}")
	public String deleteStu(@PathVariable(name="studentId") int id) {
		service.delete(id);
		return "redirect:/";
	}

}
