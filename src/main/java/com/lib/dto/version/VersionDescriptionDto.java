package com.lib.dto.version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.lib.dto.BaseModelDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VersionDescriptionDto extends BaseModelDto {

    private String version;
    private List<String> descriptions = new ArrayList<>();

    @Override
    public String getLog() {
        return null;
    }

    @Override
    public String getLogDetail() {
        return null;
    }
}
