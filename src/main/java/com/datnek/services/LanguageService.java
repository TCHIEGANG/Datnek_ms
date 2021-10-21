package com.datnek.services;


import com.lib.common.exception.GenericException;
import com.lib.models.models.language.Language;

public interface LanguageService {
    Language saveLanguage(Language language) throws GenericException;
    boolean deleteLanguage(String idServer) throws GenericException;
    Language updateLanguage(Language language) throws GenericException;
    Language findLanguageByIdServer(String idServer) throws GenericException;
    /*List<Language> findAllLanguages();
    List<Language> findAllLanguages(String languageId, int page, int size) throws GenericException;
    Page<Language> findAllLanguagesByPage(int page, int size) throws GenericException;

    Language findLanguageByEmail(String email);
    boolean deleteLanguage(String idServer) throws GenericException;
    boolean deactivateLanguage(String idServer) throws GenericException;
    Language activateLanguage(String idServer) throws GenericException;*/

}
