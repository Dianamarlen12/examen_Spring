package com.ids.examen2.controller;

import com.ids.examen2.exception.Mensaje;
import com.ids.examen2.model.Country;
import com.ids.examen2.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Countrys")
public class CountryController {
    @Autowired
    private CountryService CountryService;

    @GetMapping("/lista")
    public ResponseEntity<?> getAllCountry(){
        List<Country> lista = CountryService.getAllCountry();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin country en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(CountryService.getAllCountry());
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable long idCountry) {
        return ResponseEntity.ok().body(this.CountryService.getCountryById(idCountry));
    }

    @PostMapping("/crear")
    public ResponseEntity<Country> createCountry(@RequestBody Country Country) {
        return ResponseEntity.ok().body(this.CountryService.createCountry(Country));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long idCountry, @RequestBody Country Country){
        Country.setIdCountry(idCountry);
        return ResponseEntity.ok().body(this.CountryService.updateCountry(Country));
    }

    @DeleteMapping("/eliminar/{id}")
    public HttpStatus deleteCountry(@PathVariable long idCountry){
        this.CountryService.deleteCountry(idCountry);
        return HttpStatus.OK;
    }
}
