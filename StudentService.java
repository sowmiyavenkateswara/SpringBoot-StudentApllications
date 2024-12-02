package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentInterface;
import com.example.demo.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentInterface dao;
	// save
	public void save(Student s) {
		dao.save(s);
	}
	// update
	public Student get(int id) {
		return dao.findById(id).get();
	}
	//delete
	public void delete(int id) {
		dao.deleteById(id);
	}
	public List<Student> listAll(){
		return dao.findAll();	
		}

}
