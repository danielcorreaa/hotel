package com.hotel.hotelapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotel.hotelapp.model.Hospede;

public interface FuncionarioRepository extends CrudRepository<Hospede,Integer> {

}
