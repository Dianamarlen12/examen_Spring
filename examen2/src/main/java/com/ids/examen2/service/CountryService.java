package com.ids.examen2.service;

import com.ids.examen2.model.Country;

import java.util.List;

public interface CountryService {
    Country createCountry(Country country);
    Country updateCountry(Country country);
    List<Country> getAllCountry();
    Country getCountryById(long countryId);
    void deleteCountry(long id);
}
