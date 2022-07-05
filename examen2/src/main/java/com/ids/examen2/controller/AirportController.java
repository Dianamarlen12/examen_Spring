package com.ids.examen2.controller;

import com.ids.examen2.exception.Mensaje;
import com.ids.examen2.model.Airport;
import com.ids.examen2.service.AirportService;
import com.ids.examen2.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/lista")
    public ResponseEntity<?> getAllAirport(){
        List<Airport> lista = airportService.getAllAirports();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin airports en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.getAllAirports());
    }

    @GetMapping("/detalles/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable long idAirport) {
        return ResponseEntity.ok().body(this.airportService.getAirportById(idAirport));
    }

    @PostMapping("/crear")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok().body(this.airportService.createAirport(airport));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable long idAirport, @RequestBody Airport airport){
        airport.setIdAirport(idAirport);
        return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
    }

    @DeleteMapping("/eliminar/{id}")
    public HttpStatus deleteAirport(@PathVariable long idAirport){
        this.airportService.deleteAirport(idAirport);
        return HttpStatus.OK;
    }
}