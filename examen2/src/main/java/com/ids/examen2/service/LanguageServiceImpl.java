package com.ids.examen2.service;

import com.ids.examen2.exception.ResourceNotFoundException;
import com.ids.examen2.model.Language;
import com.ids.examen2.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language updateLanguage(Language language) {
        Optional<Language> languageDb = this.languageRepository.findById(language.getIdLanguage());

        if (languageDb.isPresent()){
            Language languageUpdate = languageDb.get();
            languageUpdate.setIdLanguage(language.getIdLanguage());
            languageUpdate.setName(language.getCode());
            languageUpdate.setCode(language.getCode());
            languageRepository.save(languageUpdate);
            return languageUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + language.getIdLanguage());
        }
    }

    @Override
    public List<Language> getAllLanguages() {
        return this.languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(long languageId) {
        Optional<Language> languageDb = this.languageRepository.findById(languageId);

        if (languageDb.isPresent()) {
            return languageDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + languageId);
        }
    }


    @Override
    public void deleteLanguaje(long languageId) {
        Optional<Language> languageDb = this.languageRepository.findById(languageId);

        if (languageDb.isPresent()) {
            this.languageRepository.delete(languageDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + languageId);
        }
    }
}

