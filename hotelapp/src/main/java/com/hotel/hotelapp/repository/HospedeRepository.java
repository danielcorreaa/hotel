package com.hotel.hotelapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotel.hotelapp.model.Hospede;

public interface HospedeRepository extends CrudRepository<Hospede,Integer> {
	List<Hospede> findAll();
}
