package com.hotel.hotelapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelapp.model.Quarto;
import com.hotel.hotelapp.repository.QuartoRepository;

@RestController
public class QuartoController {
	
	
	@Autowired
	private QuartoRepository dao;
	
	@GetMapping("/quartos")
	public ResponseEntity<?> listarQuartos(){
		return new  ResponseEntity<List<Quarto>>(new ArrayList<Quarto>(dao.findAll()), HttpStatus.OK);
	}
	
	@PostMapping("/quartos")
	public ResponseEntity<?> saveQuarto(@RequestBody Quarto quarto){
		return new ResponseEntity<Quarto>(dao.save(quarto), HttpStatus.CREATED);
	}
	
	@PutMapping("/quartos")
	public ResponseEntity<?> updateQuarto(@RequestBody Quarto quarto){
		return new ResponseEntity<Quarto>(dao.save(quarto), HttpStatus.OK);
	}
	
	@DeleteMapping("/quartos/{numeroPorta}")
	public ResponseEntity<?> deleteQuarto(@PathVariable Integer numeroPorta){
		dao.delete(numeroPorta);
		return new ResponseEntity<Quarto>(HttpStatus.OK);
	}
	
}
