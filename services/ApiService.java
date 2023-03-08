package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Grocery;
import com.example.demo.repository.ApiRepository;

@Service
public class ApiService {

	
	@Autowired
	ApiRepository  repository;
	
	public Optional<Grocery> getGrocery(int id) {
		return repository.findById(id);
	}
	
	public String deleteDetails(int id) {
		if(repository.existsById(id))
		{
		repository.deleteById(id);
		
		return "id Deleted";
		}
		else
		{
			return "error";
		}
		
	}
    public String put(int id, Grocery x)
    {
    	if(repository.existsById(id))
    	{
    		Grocery temp=repository.getReferenceById(id);
    		temp.setId(id);
    		temp.setPrice(x.getPrice());
    		temp.setProductId(x.getProductId());
    		temp.setProductName(x.getProductName());
            repository.save(temp);
            return "updated";
    	}
    	return " ";
    }
		
}
