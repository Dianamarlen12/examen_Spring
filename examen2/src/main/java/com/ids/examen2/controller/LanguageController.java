package com.ids.examen2.controller;


import com.ids.examen2.exception.Mensaje;
import com.ids.examen2.model.Language;
import com.ids.examen2.service.LanguageService;
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
@RequestMapping("/languajes")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/lista")
    public ResponseEntity<?> getAllLenguages(){
        List<Language> lista = languageService.getAllLanguages();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin employee en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(languageService.getAllLanguages());
    }

    @GetMapping("/detalles/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable long idLenguage) {
        return ResponseEntity.ok().body(this.languageService.getLanguageById(idLenguage));
    }

    @PostMapping("/crear")
    public ResponseEntity<Language> createLanguage(@RequestBody Language Languaje) {
        return ResponseEntity.ok().body(this.languageService.createLanguage(Languaje));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Language> updateLanguaje(@PathVariable long idLenguage, @RequestBody Language Language){
        Language.setIdLanguage(idLenguage);
        return ResponseEntity.ok().body(this.languageService.updateLanguage(Language));
    }

    @DeleteMapping("/delete_Languaje/{id}")
    public HttpStatus deleteLanguaje(@PathVariable long idLenguage){
        this.languageService.deleteLanguaje(idLenguage);
        return HttpStatus.OK;
    }
}

