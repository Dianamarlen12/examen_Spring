package com.ids.examen2.controller;

import com.ids.examen2.exception.Mensaje;
import com.ids.examen2.model.Airport;
import com.ids.examen2.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return new ResponseEntity<>(new Mensaje("No se encuentran aeropuertos en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.getAllAirports());
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.airportService.getAirportById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok().body(this.airportService.createAirport(airport));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport){
        airport.setId(id);
        return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
    }

    @DeleteMapping("/eliminar/{id}")
    public HttpStatus deleteAirport(@PathVariable long id){
        this.airportService.deleteAirport(id);
        return HttpStatus.OK;
    }
}
