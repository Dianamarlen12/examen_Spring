package com.ids.examen2.service;

import com.ids.examen2.model.Airport;

import java.util.List;

public interface AirportService {
    Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport);

    List<Airport> getAllAirports();

    Airport getAirportById(long idAirport);

    void deleteAirport(long idAirport);
}
