package com.hotel.hotelapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotel.hotelapp.model.Quarto;

public interface QuartoRepository extends CrudRepository<Quarto,Integer>  {
	
	List<Quarto> findAll();

}
