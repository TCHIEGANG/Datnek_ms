package com.datnek.controllers;


import com.datnek.api.LanguageApi;
import com.lib.common.enumeration.ResponseMessage;
import com.lib.common.exception.GenericException;
import com.lib.common.logging.LoggingUtil;
import com.lib.common.wrapper.GenericResultDto;
import com.lib.dto.Language.LanguageDto;
import com.lib.mapper.GenericMapper;
import com.lib.models.models.language.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class LanguageController extends AbstractController implements LanguageApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);
    private static final String defaultValueSizePage = "32";
    private static final String defaultValuePage = "0";

    @Override
    public ResponseEntity<GenericResultDto> findLanguageById(@PathVariable String languageId) throws GenericException {
        LOGGER.info("{}" , LoggingUtil.START );
        try {
        Language language = languageService.findLanguageByIdServer(languageId);

        if (language == null){
            return genericResultDtoError(ResponseMessage.LANGUAGE_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
        }

        result.setResultObject(language);
        genericResultDtoSuccess();
        LOGGER.info("{}" , LoggingUtil.END);
        return new ResponseEntity<>(result, result.getHttpHeaders(), result.getHttpStatus());

    }catch (Exception e){
        return genericResultDtoError(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    }

    @Override
    public ResponseEntity<GenericResultDto> createLanguage(@RequestBody LanguageDto languageDto) throws GenericException {
        try {

            Language language = GenericMapper.INSTANCE.asEntity(languageDto);
            language = languageService.saveLanguage(language);
            result.setResultObject(GenericMapper.INSTANCE.asDto(language));
            result.setHttpStatus(HttpStatus.OK);
            result.setMessage("Success");
        }catch (Exception e){
            return genericResultDtoError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOGGER.info("{}" , LoggingUtil.END);
        return new ResponseEntity<>(result, result.getHttpStatus());
    }

    @Override
    public ResponseEntity<GenericResultDto> updateLanguage(@RequestBody LanguageDto languageDto) throws GenericException {
        LOGGER.info("{}" , LoggingUtil.START );

        try {
            Language language = languageService.updateLanguage(GenericMapper.INSTANCE.asEntity(languageDto));
            result.setResultObject(GenericMapper.INSTANCE.asDto(language));
            genericResultDtoSuccess();
            LOGGER.info("{}" , LoggingUtil.END);
            return new ResponseEntity<>(result, result.getHttpStatus());
        }catch (Exception e){
            return genericResultDtoError(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<GenericResultDto> deleteLanguage(@PathVariable String languageId) throws GenericException {
        LOGGER.info("{}" , LoggingUtil.START );
        try {

            languageService.deleteLanguage(languageId);
            genericResultDtoSuccess();
            LOGGER.info("{}" , LoggingUtil.END);
            return new ResponseEntity<>(result, result.getHttpStatus());

        }catch (Exception e){
            return genericResultDtoError(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
