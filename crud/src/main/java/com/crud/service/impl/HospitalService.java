package com.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.data.entity.Hospital;
import com.crud.data.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> getAllHospitals() {
		List<Hospital> hospitals = new ArrayList<>();
		hospitalRepository.findAll().forEach(hospitals::add);
		return hospitals;
	}

	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public Hospital findHospById(int id) {
		return hospitalRepository.findOne(id);
	}

	public void updateHospital(Hospital hospital) {
		addHospital(hospital);
	}

	public void deleteHospital(int id) {
		hospitalRepository.delete(id);
	}

}
