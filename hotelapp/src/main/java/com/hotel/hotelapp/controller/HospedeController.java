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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelapp.model.Hospede;
import com.hotel.hotelapp.repository.HospedeRepository;

@RestController
public class HospedeController {

	@Autowired
	private HospedeRepository hospedeDAO;

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	@GetMapping("hospedes")
	public ResponseEntity<?> listar() {
		return new ResponseEntity<List<Hospede>>(new ArrayList<Hospede>(hospedeDAO.findAll()), HttpStatus.OK);
	}

	@PostMapping("hospedes")
	public ResponseEntity<?> save(@RequestBody Hospede hospede) {
		return new ResponseEntity<Hospede>(hospedeDAO.save(hospede), HttpStatus.CREATED);
	}

	@PutMapping("hospedes")
	public ResponseEntity<?> update(@RequestBody Hospede hospede) {
		return new ResponseEntity<Hospede>(hospedeDAO.save(hospede), HttpStatus.OK);
	}

	@DeleteMapping("/hospedes/{id}")
	public ResponseEntity<?> delete(@PathVariable Hospede hospede) {
		hospedeDAO.delete(hospede);
		return new ResponseEntity<Hospede>(HttpStatus.OK);
	}
}