package com.ids.examen2.repository;


import com.ids.examen2.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository <Language, Long> {

}