package com.crud.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.data.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	@Query(value = "from HOSPITAL", nativeQuery = true)
	/* @Query(value = "from Hospital" */
	/*
	 * if nativequery true then it is sql query and if not then it is hibernate
	 * query so we have to write Entity name and it is case sensitive unlike sql
	 * which is case insensitive
	 */
	List<Hospital> getAllHospitals();

}