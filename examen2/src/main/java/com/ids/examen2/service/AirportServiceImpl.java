package com.ids.examen2.service;

import com.ids.examen2.exception.ResourceNotFoundException;
import com.ids.examen2.model.Airport;
import com.ids.examen2.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRepository.findById(airport.getIdAirport());

        if (airportDb.isPresent()){
            Airport airportUpdate = airportDb.get();
            airportUpdate.setIdAirport(airport.getIdAirport());
            airportUpdate.setName(airport.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getIdAirport());
        }
    }

    @Override
    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long idAirport) {
        Optional<Airport> airportDb = this.airportRepository.findById(idAirport);

        if (airportDb.isPresent()) {
            return airportDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + idAirport);
        }
    }

    @Override
    public void deleteAirport(long idAirport) {
        Optional<Airport> airportDb = this.airportRepository.findById(idAirport);

        if (airportDb.isPresent()) {
            this.airportRepository.delete(airportDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + idAirport);
        }
    }
}
