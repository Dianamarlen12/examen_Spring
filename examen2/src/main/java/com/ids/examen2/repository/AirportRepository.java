package com.ids.examen2.repository;

import com.ids.examen2.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository <Airport, Long> {

}