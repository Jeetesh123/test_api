package com.test.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.entity.TestEntity;
import com.test.demo.repository.TestRepository;

@RestController
public class TestController {
	
	@Autowired
	private TestRepository testRepository;
	
	@GetMapping("/getAllData")
	public List<TestEntity> getAllData() {
		return testRepository.findAll();
	}
	
	@GetMapping("/getAllFADataByRegion/{regionParam}")
	public List<TestEntity> getAllFADataByRegion(@PathVariable("regionParam") String regionParam) {
		return testRepository.findFAbyRegion(regionParam);
	}
	
	@GetMapping("/getAllFADataById/{id}")
	public List<TestEntity> getAllFADataByID(@PathVariable("id") Integer id) {
		return testRepository.findFAbyID(id);
	}
	
}
