package com.datnek.api;

import com.lib.common.exception.GenericException;
import com.lib.common.wrapper.GenericResultDto;
import com.lib.dto.Language.LanguageDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
public interface LanguageApi {
    /*@GetMapping
    ResponseEntity<GenericResultDto> findAllLanguages() throws GenericException;
*/
    @GetMapping(value = "/{languageId}")
    ResponseEntity<GenericResultDto> findLanguageById(String languageId) throws GenericException;

    @PutMapping
    ResponseEntity<GenericResultDto> updateLanguage(LanguageDto languageDto) throws GenericException;

    @PostMapping
    ResponseEntity<GenericResultDto> createLanguage(LanguageDto languageDto) throws GenericException;

    @DeleteMapping(value = "/{languageId}")
    ResponseEntity<GenericResultDto> deleteLanguage(String languageId) throws GenericException;

}
