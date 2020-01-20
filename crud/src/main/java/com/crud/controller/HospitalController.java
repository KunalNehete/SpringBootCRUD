package com.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.data.entity.Hospital;
import com.crud.service.impl.HospitalService;

@RestController
@RequestMapping("/test/")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	List<Hospital> hosp = new ArrayList<Hospital>();

	@RequestMapping(value = "/hospitals", method = RequestMethod.GET)
	public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
		hosp = hospitalService.getAllHospitals();
		return hosp;
	}

	@RequestMapping(value = "/addHosp", method = RequestMethod.POST)
	public @ResponseBody String addHosp(@RequestBody Hospital hospital) {
		System.out.println("#########addHosp()#########");
		hospitalService.addHospital(hospital);
		return "JSON: Hospital name: " + hospital.getName() + ", City: "
				+ hospital.getCity() + ", Rating: " + hospital.getRating();
	}

	@RequestMapping(value = "/hospital/{id}", method = RequestMethod.PUT)
	public String updateHospital(@PathVariable(value = "id") int id,
			@RequestBody Hospital hospital) {
		System.out.println("#########updateHosp()#########");
		Hospital currentHospital = hospitalService.findHospById(id);

		if (currentHospital == null) {
			return "Error occured while updating";
		}

		currentHospital.setName(hospital.getName());
		currentHospital.setCity(hospital.getCity());
		currentHospital.setRating(hospital.getRating());

		hospitalService.updateHospital(currentHospital);

		return "JSON: Hospital name: " + currentHospital.getName() + ", City: "
				+ currentHospital.getCity() + ", Rating: "
				+ currentHospital.getRating();
	}

	// ------------------- Delete a Hospital
	// -----------------------------------------

	@RequestMapping(value = "/deleteHospital/{id}", method = RequestMethod.DELETE)
	public String deleteHospital(@PathVariable(value = "id") int id) {
		System.out.println("#########deleteHosp()#########");

		hospitalService.deleteHospital(id);

		return "delete method executed!";
	}

}