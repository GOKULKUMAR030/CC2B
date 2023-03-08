package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Grocery;
import com.example.demo.repository.ApiRepository;
import com.example.demo.services.ApiService;
@CrossOrigin
@RestController
public class ApiController {

	@Autowired
	ApiRepository serviceRepository;
	@Autowired
	ApiService service;
	
	@GetMapping("/getgroceryList")
	List<Grocery> getList()
	{
		return serviceRepository.findAll();
	}
	@PostMapping("/groceryList")
	public Grocery create(@RequestBody Grocery t) 
	{
		return serviceRepository.save(t);
	}
	
	
	@DeleteMapping("/del/{id}")
		public String delete(@PathVariable int id) {
			return service.deleteDetails(id);
		}
	
}
	
