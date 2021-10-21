package com.lib.dto.Language;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lib.dto.BaseActiveModelDto;
import com.lib.dto.Language.config.LevelDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageDto extends BaseActiveModelDto {

    private LevelDto spokenLevel;

    private LevelDto writtenLevel;

    private LevelDto comprehensionLevel;

    private String code;


    @Override
    public String getLog() {
        return null;
    }

    @Override
    public String getLogDetail() {
        return null;
    }
}
