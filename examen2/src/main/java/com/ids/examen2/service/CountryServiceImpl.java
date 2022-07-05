package com.ids.examen2.service;

import com.ids.examen2.exception.ResourceNotFoundException;
import com.ids.examen2.model.Country;
import com.ids.examen2.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> countryDb = this.countryRepository.findById(country.getIdCountry());
        if (countryDb.isPresent()){
            Country countryUpdate = countryDb.get();
            countryUpdate.setIdCountry(country.getIdCountry());
            countryUpdate.setCode(country.getCode());
            countryUpdate.setName(country.getName());
            countryRepository.save(countryUpdate);
            return countryUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + country.getIdCountry());
        }
    }

    @Override
    public List<Country> getAllCountry() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long idCountry) {
        Optional<Country> countryDb = this.countryRepository.findById(idCountry);
        if(countryDb.isPresent()){
            return countryDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + idCountry);
        }
    }

    @Override
    public void deleteCountry(long idCountry) {
        Optional<Country> countryDb = this.countryRepository.findById(idCountry);
        if(countryDb.isPresent()){
            this.countryRepository.delete(countryDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + idCountry);
        }
    }
}
