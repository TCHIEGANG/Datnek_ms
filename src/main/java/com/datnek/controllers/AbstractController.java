package com.datnek.controllers;

import com.datnek.services.LanguageService;
import com.lib.common.exception.GenericException;
import com.lib.common.exception.InvalidParameterException;
import com.lib.common.logging.LoggingHelper;
import com.lib.common.wrapper.GenericResultDto;
import com.lib.models.repositories.language.LanguageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController {
    
    protected static final String PAGE = "page";
    protected static final String LIMIT = "limit";
    protected static final String CONTENT = "content";
    protected static final String COUNTRY = "country";
    protected static final String STATUS = "status";

    @Autowired
    protected LanguageService languageService;
   

    protected GenericResultDto result = null;
    

    protected ResponseEntity<GenericResultDto> genericResultDtoError(String message, HttpStatus httpStatus){
        InvalidParameterException e = new InvalidParameterException(message);
        result = new GenericResultDto();
        result.setHttpStatus(httpStatus);
        result.setMessage(e.getMessage());
        result.setGenericMessageDetailsList(LoggingHelper.buildGenericMessageDetails(e));
        return new ResponseEntity<>(result, result.getHttpStatus());
    }

    protected GenericResultDto processToken(String token, String id) throws GenericException {
        if (StringUtils.isBlank(token) || StringUtils.isBlank(id)){
            throw new GenericException("Invalid input data");
        }
        result = new GenericResultDto<>();
        return result;
    }

    protected void genericResultDtoSuccess(){
        result.setHttpStatus(HttpStatus.OK);
        result.setMessage("Success");
    }
}
