package com.lib.models.repositories.language;

import com.lib.models.models.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{
    Optional<Language> findByIdServer(String idServer);
    }

