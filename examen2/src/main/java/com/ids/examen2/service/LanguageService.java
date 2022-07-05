package com.ids.examen2.service;

import com.ids.examen2.model.Airport;
import com.ids.examen2.model.Language;

import java.util.List;

public interface LanguageService {
    Language createLanguage(Language language);

    Language updateLanguage(Language language);

    List<Language> getAllLanguages();

    Language getLanguageById(long languageId);

    //void deleteLanguage(long id);

    void deleteLanguaje(long id);
}
