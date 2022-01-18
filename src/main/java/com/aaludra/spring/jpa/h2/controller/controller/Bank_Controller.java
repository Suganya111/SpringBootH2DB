package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bank_Acc;
import com.example.demo.repository.BankDao;
import com.example.demo.service.BankService;
@RestController
public class Bank_Controller {
	@Autowired
	private BankService bankservice;
	@GetMapping("/getAll")
	public ResponseEntity<List<Bank_Acc>> getAllBank_Acc(){
		return ResponseEntity.ok().body(bankservice.getAllBank_Acc());
		
	}
	@GetMapping("/getId/{id}")
	public ResponseEntity<Bank_Acc> getBank_AccById(@PathVariable long id){
		return ResponseEntity.ok().body(bankservice.getBank_AccById(id));
		
	}
	@PostMapping("/create")
	public ResponseEntity<Bank_Acc> createBank_Acc(@RequestBody Bank_Acc bank){
		return ResponseEntity.ok().body(this.bankservice.createBank_Acc(bank));
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Bank_Acc> updateBank_Acc(@PathVariable long id, @RequestBody Bank_Acc bank){
		bank.setId(id);
		return ResponseEntity.ok().body(this.bankservice.updateBank_Acc(bank));	
	}
	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.bankservice.deleteBank_Acc(id);
		return HttpStatus.OK;
		
	}
	
}
